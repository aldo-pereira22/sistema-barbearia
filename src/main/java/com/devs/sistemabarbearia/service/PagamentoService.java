package com.devs.sistemabarbearia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devs.sistemabarbearia.model.Cliente;
import com.devs.sistemabarbearia.model.Pagamento;
import com.devs.sistemabarbearia.pessoa.repository.PagamentoRepository;
import com.devs.sistemabarbearia.pessoa.repository.PessoaRepository;

@Service
public class PagamentoService {

	@Autowired
	PagamentoRepository repository;
	
	public List<Pagamento> buscarTodos(){
		return repository.findAll();
	}
	
	public Pagamento salvarCliente(Pagamento pagamento) {
		return repository.save(pagamento);
	}
	
	public Pagamento buscarPorId(Long id) {
		return repository.findByid(id);
		
	}
	
	public void excluir(Pagamento pagamento) {
		repository.delete(pagamento);
	}
	
	public Pagamento atualizar(Pagamento pagamento) {
		return repository.save(pagamento);
	}
}
