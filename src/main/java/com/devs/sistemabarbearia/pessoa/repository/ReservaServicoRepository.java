package com.devs.sistemabarbearia.pessoa.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devs.sistemabarbearia.model.ReservaDeServico;

@Repository
public interface ReservaServicoRepository  extends JpaRepository<ReservaDeServico, Long>{

	ReservaDeServico findByid(Long ind);

		
}
