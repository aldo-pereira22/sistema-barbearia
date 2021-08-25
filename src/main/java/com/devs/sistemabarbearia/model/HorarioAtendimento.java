package com.devs.sistemabarbearia.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin

@Entity
public class HorarioAtendimento {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private LocalDate Inicio;
	private LocalDate Fim;
	

	@OneToMany(mappedBy = "horarioAtendimento")
	private List<Agenda> agendas;
	
//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name="horario_")
//	private List<Horario> lista_de_horario;

	
//	public List<Horario> getLista_de_horario() {
//		return lista_de_horario;
//	}
//
//	public void setLista_de_horario(List<Horario> lista_de_horario) {
//		this.lista_de_horario = lista_de_horario;
//	}

	public List<Agenda> getAgendas() {
		return agendas;
	}

	public void setAgendas(List<Agenda> agendas) {
		this.agendas = agendas;
	}

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



	public HorarioAtendimento() {
		
	}
}
