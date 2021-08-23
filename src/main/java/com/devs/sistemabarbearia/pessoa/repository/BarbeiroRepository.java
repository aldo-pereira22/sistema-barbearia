package com.devs.sistemabarbearia.pessoa.repository;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.devs.sistemabarbearia.model.Barbeiro;
import com.devs.sistemabarbearia.service.AgendaService;

@Repository
public interface BarbeiroRepository  extends JpaRepository<Barbeiro, Long>{

	Barbeiro findByid(long ind);
	
	
	@Transactional(readOnly=true)
	Barbeiro findByEmail(String email);
		
}
