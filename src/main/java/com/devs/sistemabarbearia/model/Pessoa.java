package com.devs.sistemabarbearia.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Pessoa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String cpf;
	private String nome;
	private Date dataNascimento;
	private String email;
	private String senha;
	private String tipo;
	
	
	
}
