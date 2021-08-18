package com.devs.sistemabarbearia.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import com.devs.sistemabarbearia.model.enums.Perfil;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Barbeiro implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;	
	private String cpf;
	private String nome;
	private String email;
	
	@JsonIgnore
	private String senha;
	private Integer perfil;
	
	@OneToOne
	private Agenda agenda;
	
	
	@ManyToMany(mappedBy = "barbeiros")
	private List<Servico> servicos = new ArrayList<Servico>();
	

	public List<Servico> getServicos() {
		return servicos;
	}

	public void setServicos(List<Servico> servico) {
		this.servicos = servico;
	}

	public Barbeiro() {
		
	}

	public Barbeiro(Long id, String cpf, String nome, String email, String senha, Perfil perfil) {
		super();
		this.id = id;
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.perfil = perfil.getCod();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Perfil getPerfil() {
		return Perfil.toEnum(perfil);
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil.getCod();
	}

	public Agenda getAgenda() {
		return agenda;
	}

	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
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
		Barbeiro other = (Barbeiro) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	


	
}
