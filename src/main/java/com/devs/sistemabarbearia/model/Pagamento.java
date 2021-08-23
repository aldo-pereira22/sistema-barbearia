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
	
	private Double valor;
	
}
