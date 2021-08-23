package com.devs.sistemabarbearia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devs.sistemabarbearia.model.ReservaDeServico;
import com.devs.sistemabarbearia.pessoa.repository.HorarioRepository;
import com.devs.sistemabarbearia.pessoa.repository.ReservaServicoRepository;

@Service
public class ReservaServicoService {

	@Autowired
	ReservaServicoRepository repository;
	
	@Autowired
	HorarioRepository horarioService;
	
	public ReservaDeServico salvar(ReservaDeServico reserva) {
		
		return repository.save(reserva);
	}

	public void delete(ReservaDeServico reserva) {
		repository.delete(reserva);	
	}
	
	public ReservaDeServico save(ReservaDeServico reserva){
		return repository.save(reserva);
	}

	public ReservaDeServico findById(Long id) {	
		return repository.findByid(id);
	}

	
	public List<ReservaDeServico> findAll() {	
		return repository.findAll();
	}
	

}
