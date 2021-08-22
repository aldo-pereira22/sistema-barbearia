package com.devs.sistemabarbearia.pessoa.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devs.sistemabarbearia.model.Agenda;

@Repository
public interface AgendaRepository  extends JpaRepository<Agenda, Long>{

	Agenda findByid(Long ind);
	
}
