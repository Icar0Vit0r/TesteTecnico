package com.example.cartorios.principal;

import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Certidao {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nomeCertidao;
	
	@ManyToOne
	private Optional<Cartorio> cartorio;
	
	public Optional<Cartorio> getCartorio() {
		return cartorio;
	}

	public void setCartorio(Optional<Cartorio> cartorio) {
		this.cartorio = cartorio;
	}

	public Certidao(String nomeCertidao) {
		this.nomeCertidao = nomeCertidao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeCertidao() {
		return nomeCertidao;
	}

	public void setNomeCertidao(String nomeCertidao) {
		this.nomeCertidao = nomeCertidao;
	}

}
