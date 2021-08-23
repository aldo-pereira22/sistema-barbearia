package com.devs.sistemabarbearia.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Agenda {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.MERGE)
	private Barbeiro barbeiro;
	
	@OneToOne
	private HorarioAtendimento horarioAtendimento;
	
	@OnDelete(action = OnDeleteAction.CASCADE)
	@OneToMany(mappedBy = "agenda" , fetch = FetchType.EAGER)
	List<ReservaDeServico> listaDeReservas = new ArrayList<ReservaDeServico>();


	public List<ReservaDeServico> getListaDeReservas() {
		return listaDeReservas;
	}




	public HorarioAtendimento getHorarioAtendimento() {
		return horarioAtendimento;
	}




	public void setHorarioAtendimento(HorarioAtendimento horarioAtendimento) {
		this.horarioAtendimento = horarioAtendimento;
	}




	public void setListaDeReservas(List<ReservaDeServico> listaDeReservas) {
		this.listaDeReservas = listaDeReservas;
	}
	
	

	
	public Agenda() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	

	public Agenda(Long id, Barbeiro barbeiro) {
		super();
		this.id = id;
		this.setBarbeiro(barbeiro);
	}

	public Barbeiro getBarbeiro() {
		return barbeiro;
	}
	public void setBarbeiro(Barbeiro barbeiro) {
		this.barbeiro = barbeiro;
	}
	
	
	
}
