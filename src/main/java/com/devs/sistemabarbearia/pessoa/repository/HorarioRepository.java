package com.devs.sistemabarbearia.pessoa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devs.sistemabarbearia.model.Horario;
import com.devs.sistemabarbearia.model.Servico;

@Repository
public interface HorarioRepository extends JpaRepository<Horario, Long> {
	
	Horario findByid(Long ind);
	
}