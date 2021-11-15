package com.example.cartorios.principal;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Cartorio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String nome;
	
	private String endereco;
	
	@OneToMany
	private List<Certidao> Certidoes;


	@Deprecated
	protected Cartorio( ) {
		
	}
	
	public Cartorio(String nome, String Endereco) {
		this.nome = nome;
		this.endereco = endereco;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public List getCertidoes() {
		return Certidoes;
	}

	public void setCertidoes(List certidoes) {
		Certidoes = certidoes;
	} 
	
	
	
}
