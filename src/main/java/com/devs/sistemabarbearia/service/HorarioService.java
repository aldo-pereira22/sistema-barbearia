package com.devs.sistemabarbearia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devs.sistemabarbearia.model.Horario;
import com.devs.sistemabarbearia.pessoa.repository.HorarioRepository;

@Service
public class HorarioService {

	@Autowired
	HorarioRepository repository;
	
	public List<Horario> buscarTodos(){
		return repository.findAll();
	}
	
	public Horario salvar(Horario horario) {
		return repository.save(horario);
	}
	
	public Horario buscarPorId(Long id) {
		return repository.findByid(id);
		
	}
	
	public void excluir(Horario horario) {
		repository.delete(horario);
	}
	
	public Horario atualizar(Horario horario) {
		return repository.save(horario);
	}
}
