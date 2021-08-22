package com.devs.sistemabarbearia.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
public class ReservaDeServico {
	
	public ReservaDeServico() {
		// TODO Auto-generated constructor stub
	}

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;	

	@ManyToOne()
	@JoinColumn(name = "agenda_id")
	private Agenda agenda; 
	
//  Anotação para previnir o erro: No serializer found for class 
//	org.hibernate.proxy.pojo.bytebuddy.ByteBuddyInterceptor
//	and no properties discovered to create BeanSerializer 
//fonte: https://stackoverflow.com/questions/52656517/no-serializer-found-for-class-org-hibernate-proxy-pojo-bytebuddy-bytebuddyinterc
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})  
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
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
