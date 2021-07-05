package com.devs.sistemabarbearia.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Servico implements Serializable {

	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nome;
	private double valor;
	private int tempo;
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "BARBEIRO_SERVICO",
				joinColumns = @JoinColumn(name= "servico_id"),
				inverseJoinColumns = @JoinColumn(name="barbeiro_id")
			)
	private List<Barbeiro> barbeiros = new ArrayList<Barbeiro>();
	
	
	public Servico(Long id, String nome, double valor, int tempo) {
		super();
		this.id = id;
		this.nome = nome;
		this.valor = valor;
		this.tempo = tempo;
	}

	public Servico() {
		// TODO Auto-generated constructor stub
	}


	public String getNome() {
		
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public int getTempo() {
		return tempo;
	}

	public void setTempo(int tempo) {
		this.tempo = tempo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Servico other = (Servico) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public List<Barbeiro> getBarbeiros() {
		return barbeiros;
	}

	public void setBarbeiros(List<Barbeiro> barbeiros) {
		this.barbeiros = barbeiros;
	}
	
	
}
