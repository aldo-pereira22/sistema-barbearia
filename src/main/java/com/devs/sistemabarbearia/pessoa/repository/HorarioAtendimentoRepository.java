package com.devs.sistemabarbearia.pessoa.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devs.sistemabarbearia.model.HorarioAtendimento;
import com.devs.sistemabarbearia.model.ReservaDeServico;

@Repository
public interface HorarioAtendimentoRepository  extends JpaRepository<HorarioAtendimento, Long>{

	HorarioAtendimento findByid(Long ind);

		
}
