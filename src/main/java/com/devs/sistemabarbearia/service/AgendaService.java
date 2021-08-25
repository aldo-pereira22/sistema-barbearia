package com.devs.sistemabarbearia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devs.sistemabarbearia.model.Agenda;
import com.devs.sistemabarbearia.pessoa.repository.AgendaRepository;

@Service
public class AgendaService {

	
	@Autowired
	AgendaRepository repository;
	
	public Agenda save(Agenda agenda) {
		return repository.save(agenda);
	}

	public void delete(Agenda agenda) {
		repository.delete(agenda);		
	}

	public Agenda findById(Long id) {
	
		return repository.findByid(id);
	}

	public List<Agenda> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}
	

}
