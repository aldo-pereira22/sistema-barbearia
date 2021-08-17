package com.devs.sistemabarbearia.service;

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
	
	
	
}
