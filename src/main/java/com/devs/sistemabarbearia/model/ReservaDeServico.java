package com.devs.sistemabarbearia.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class ReservaDeServico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;	
	
	private boolean concluido ;
	
	@JsonIgnore
	@ManyToOne()
	@JoinColumn(name = "agenda_id")
	private Agenda agenda;
			
	@OneToOne
    private Cliente cliente;
    
    @ManyToOne
    private Servico servicos;
    
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "reserva")
    private Pagamento pagamento;

    @OneToOne(cascade = CascadeType.ALL)
    private Horario horario;

	public Horario getHorario() {
		return horario;
	}

	
	public void setHorario(Horario horario) {
		this.horario = horario;
	}


    
    
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

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}



	public ReservaDeServico() {
		// TODO Auto-generated constructor stub
	}


	public boolean isConcluido() {
		return concluido;
	}


	public void setConcluido(boolean concluido) {
		this.concluido = concluido;
	}
	
}
