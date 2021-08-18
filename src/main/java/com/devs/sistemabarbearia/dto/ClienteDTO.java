package com.devs.sistemabarbearia.dto;

import java.io.Serializable;

import com.devs.sistemabarbearia.model.Cliente;

public class ClienteDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private String email;
	
	public ClienteDTO() {
	
	}
	
	public ClienteDTO(Cliente cliente) {
		this.id = cliente.getId();
		this.nome =  cliente.getNome();
		this.email = cliente.getEmail();
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}
