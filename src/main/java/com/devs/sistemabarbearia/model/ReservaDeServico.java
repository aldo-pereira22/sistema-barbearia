package com.devs.sistemabarbearia.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;



@Entity
public class ReservaDeServico {
	
	public ReservaDeServico() {
		// TODO Auto-generated constructor stub
	}

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;	

	@ManyToOne
	private Agenda agenda;
	

    @ManyToOne(fetch = FetchType.LAZY)
    private Cliente cliente;
    
    @ManyToOne
    private Servico servicos;
    
   

	public Servico getServicos() {
		return servicos;
	}

	public void setServicos(Servico servicos) {
		this.servicos = servicos;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Agenda getAgenda() {
		return agenda;
	}

	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}



	
}
