package com.devs.sistemabarbearia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devs.sistemabarbearia.model.Barbeiro;
import com.devs.sistemabarbearia.pessoa.repository.BarbeiroRepository;

@Service
public class BarbeiroService {

	
	@Autowired
	BarbeiroRepository repository;
	
	public Barbeiro salvar(Barbeiro barbeiro) {
		return repository.save(barbeiro);
	}

	public void delete(Barbeiro barbeiro) {

		repository.delete(barbeiro);
		
	}
	
	public Barbeiro save(Barbeiro barbeiro) {
		return repository.save(barbeiro);
	}

	public Barbeiro findById(Long id) {
	
		return repository.findByid(id);
	}

	public List<Barbeiro> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	public void saveAll(List<Barbeiro> asList) {
		repository.saveAll(asList);
		
	}
	

}
