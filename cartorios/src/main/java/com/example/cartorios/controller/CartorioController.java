package com.example.cartorios.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.cartorios.principal.Cartorio;
import com.example.cartorios.principal.CartorioRepositorio;
import com.example.cartorios.principal.Certidao;
import com.example.cartorios.principal.CertidaoRepositorio;

@Controller
public class CartorioController {

	private CartorioRepositorio cartorioRepo;
	
	private CertidaoRepositorio certidaoRepo;
	
	public CartorioController(CartorioRepositorio cartorioRepo) {
		this.cartorioRepo = cartorioRepo;
	}
	
	@GetMapping("/principal/cartorios")
	public String cartorios(Model model) {
		model.addAttribute("listaCartorios", cartorioRepo.findAll());
		return "principal/cartorios/index"; 
	}
	
	@GetMapping("/principal/cartorios/novo")
	public String inserirCartorio(@ModelAttribute("Cartorio") Cartorio cartorio) {
		return "principal/cartorios/form";
	}
	
	@PostMapping("/principal/cartorios/salvar")
	public String salvarCartorio(@ModelAttribute("Cartorio") Cartorio cartorio) {
		cartorioRepo.save(cartorio);
		return "redirect:/principal/cartorios";
	}
	
	@GetMapping("/principal/cartorios/{id}")
	public String alterarCartorio(@PathVariable("id") long id, Model model) {
		Optional<Cartorio> cartorioOpt = cartorioRepo.findById(id);
		if (!cartorioOpt.isPresent()) {
			throw new IllegalArgumentException("Cartório inválido.");
		}
		
		model.addAttribute("cartorio", cartorioOpt.get());
		
		return "principal/cartorio/form";
	}
	
	@GetMapping("/principal/cartorios/excluir/{id}")
	public String excluirCartorio(@PathVariable("id") long id) {
		Optional<Cartorio> cartorioOpt = cartorioRepo.findById(id);
		if (cartorioOpt.isEmpty()) {
			throw new IllegalArgumentException("Cartório inválido.");
		}
		
		cartorioRepo.delete(cartorioOpt.get());
		return "redirect:/principal/cartorios";
	}
	
	@GetMapping("/principal/cartorios/{id}")
	public String adicionarCertidao(@PathVariable("id") long id, Certidao certidao) {
		
		Optional<Cartorio> cartorioOpt = cartorioRepo.findById(id);
		certidao.setCartorio(cartorioOpt);
		if (cartorioOpt.isEmpty()) {
			throw new IllegalArgumentException("Cartório inválido.");
		}
		
		cartorioRepo.save(cartorioOpt.get());
		certidaoRepo.save(certidao);
		return "redirect:/principal/cartorios";
	}
	
	
	
	
	
}
