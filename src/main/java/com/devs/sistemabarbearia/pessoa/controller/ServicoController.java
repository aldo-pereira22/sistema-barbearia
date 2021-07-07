package com.devs.sistemabarbearia.pessoa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devs.sistemabarbearia.model.Servico;
import com.devs.sistemabarbearia.pessoa.repository.ServicoRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping(value = "/servicos")
@CrossOrigin(origins = "*")
public class ServicoController {

	@Autowired
	ServicoRepository servicoRepository;

	@GetMapping(value = "/servicos")
	public List<Servico> listaServicos() {
		return servicoRepository.findAll();
	}

	@PostMapping("/servicos")
	public Servico salvarServico(@RequestBody Servico servico) { // RequestBody, dá acesso aos atributos que estão no
																	// arquivo JSON
		return servicoRepository.save(servico);
	}

	@DeleteMapping("/servicos")
	public void deletaServico(@RequestBody Servico servico) {
		servicoRepository.delete(servico);
	}

	@PutMapping("/servicos")
	public Servico update(@RequestBody Servico servico) {
		return servicoRepository.save(servico);
	}

	@GetMapping("/servicos/{id}")
	public Servico buscaServicoId(@PathVariable(value = "id") Long id) throws ObjectNotFoundException {
		Servico servico = servicoRepository.findByid(id);
		if (servico == null) {
			throw new ObjectNotFoundException("Serviço com ID: " + id + " Não encontrado!");
		}

		return servico;
	}

}
