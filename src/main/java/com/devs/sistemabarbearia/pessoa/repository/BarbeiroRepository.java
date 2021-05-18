package com.devs.sistemabarbearia.pessoa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devs.sistemabarbearia.model.Pessoa;

public interface BarbeiroRepository  extends JpaRepository<Pessoa, Long>{

	Pessoa findByid(long ind);
	
	
}
