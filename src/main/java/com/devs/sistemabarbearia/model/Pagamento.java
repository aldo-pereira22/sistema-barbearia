package com.devs.sistemabarbearia.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

@Entity
public class Pagamento {
	
	@Id
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "reserva_serviço_id")
	@MapsId
	private ReservaDeServico reserva;
	private Double valorTotal;
	
	private String descricao;
	
	private String formaPagamento;
	
	private boolean pago = false;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ReservaDeServico getReserva() {
		return reserva;
	}

	public void setReserva(ReservaDeServico reserva) {
		this.reserva = reserva;
	}

	public Double getValor() {
		return valorTotal;
	}

	public void setValor(Double valor) {
		this.valorTotal = valor;
	}

	public boolean isPago() {
		return pago;
	}

	public void setPago(boolean pago) {
		this.pago = pago;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
