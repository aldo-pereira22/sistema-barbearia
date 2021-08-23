package com.devs.sistemabarbearia.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class HorarioAtendimento {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private LocalDate Inicio;
	private LocalDate Fim;

	@OneToOne
	private Agenda agenda;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getInicio() {
		return Inicio;
	}

	public void setInicio(LocalDate inicio) {
		Inicio = inicio;
	}

	public LocalDate getFim() {
		return Fim;
	}

	public void setFim(LocalDate fim) {
		Fim = fim;
	}




	public Agenda getAgenda() {
		return agenda;
	}

	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}

	public HorarioAtendimento() {
		
	}
}
