package com.devs.sistemabarbearia.pessoa.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devs.sistemabarbearia.model.Agenda;
import com.devs.sistemabarbearia.model.Pagamento;

@Repository
public interface PagamentoRepository  extends JpaRepository<Pagamento, Long>{

	Pagamento findByid(Long ind);
	
}
