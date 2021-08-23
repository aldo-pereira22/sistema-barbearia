package com.devs.sistemabarbearia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devs.sistemabarbearia.model.Cliente;
import com.devs.sistemabarbearia.model.HorarioAtendimento;
import com.devs.sistemabarbearia.pessoa.repository.HorarioAtendimentoRepository;
import com.devs.sistemabarbearia.pessoa.repository.PessoaRepository;

@Service
public class HorarioAtendimentoService {

	@Autowired
	HorarioAtendimentoRepository repository;
	
	public List<HorarioAtendimento> buscarTodos(){
		return repository.findAll();
	}
	
	public HorarioAtendimento salvarCliente(HorarioAtendimento horarioAtendimento) {
		return repository.save(horarioAtendimento);
	}
	
	public HorarioAtendimento buscarPorId(Long id) {
		return repository.findByid(id);
		
	}
	
	public void excluir(HorarioAtendimento horarioAtendimento) {
		repository.delete(horarioAtendimento);
	}
	
	public HorarioAtendimento atualizar(HorarioAtendimento horarioAtendimento) {
		return repository.save(horarioAtendimento);
	}
}
