package com.devs.sistemabarbearia.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class Horario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private boolean ativo;	
	private Date inicio;
	private Date fim;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public ReservaDeServico getReserva() {
		return reserva;
	}

	public void setReserva(ReservaDeServico reserva) {
		this.reserva = reserva;
	}

	public void setFim(Date fim) {
		this.fim = fim;
	}

	@OneToOne(mappedBy = "horario")
	private ReservaDeServico reserva;
	
	public Horario() {
		
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	
	
	
}
