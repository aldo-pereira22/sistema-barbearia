package com.devs.sistemabarbearia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devs.sistemabarbearia.model.Cliente;
import com.devs.sistemabarbearia.pessoa.repository.PessoaRepository;

@Service
public class ClienteService {

	@Autowired
	PessoaRepository pessoaRepositroy;
	
	public List<Cliente> buscarTodos(){
		return pessoaRepositroy.findAll();
	}
	
	public Cliente salvarCliente(Cliente cliente) {
		return pessoaRepositroy.save(cliente);
	}
	
	public Cliente buscarPorId(Long id) {
		return pessoaRepositroy.findByid(id);
		
	}
	
	public void excluir(Cliente cliente) {
		pessoaRepositroy.delete(cliente);
	}
	
	public Cliente atualizar(Cliente cliente) {
		return pessoaRepositroy.save(cliente);
	}
}
