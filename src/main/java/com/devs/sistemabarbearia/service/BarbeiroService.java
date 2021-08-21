package com.devs.sistemabarbearia.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devs.sistemabarbearia.model.Barbeiro;
import com.devs.sistemabarbearia.model.Servico;
import com.devs.sistemabarbearia.pessoa.repository.BarbeiroRepository;

@Service
public class BarbeiroService {

	
	@Autowired
	BarbeiroRepository repository;
	
	public Barbeiro salvar(Barbeiro barbeiro) {
		return repository.save(barbeiro);
	}

	public void delete(Barbeiro barbeiro) {
		
		
		List<Servico> s = new ArrayList<Servico>();
		
		barbeiro.setServicos(s);
		

		repository.save(barbeiro);
		Barbeiro b = repository.findByid(barbeiro.getId());
		
		repository.delete(b);
		
	}
	

}
