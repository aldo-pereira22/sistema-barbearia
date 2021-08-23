package com.devs.sistemabarbearia.pessoa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devs.sistemabarbearia.model.Cliente;

@Repository
public interface PessoaRepository  extends JpaRepository<Cliente, Long>{

	Cliente findByid(Long ind);
	
	
}
