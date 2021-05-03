package com.devs.sistemabarbearia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devs.sistemabarbearia.model.Pessoa;

public interface PessoaRepository  extends JpaRepository<Pessoa, Long>{

	Pessoa findByid(long ind);
	
	
}
