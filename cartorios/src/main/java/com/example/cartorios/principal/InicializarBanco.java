package com.example.cartorios.principal;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Transactional
public class InicializarBanco implements CommandLineRunner{
	
	@Autowired
	private CartorioRepositorio cartorioRepo;
	
	@Override
	public void run(String... args) throws Exception{
		// List certidoes = new List<>;
		Cartorio c1 = new Cartorio("Icaro", "Rua da Laranja, 24, Rio Corrente, Petrolina");
		
		cartorioRepo.save(c1);
	}

}
