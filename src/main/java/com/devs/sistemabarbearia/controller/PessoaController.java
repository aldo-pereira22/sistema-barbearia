package com.devs.sistemabarbearia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.devs.sistemabarbearia.model.Pessoa;
import com.devs.sistemabarbearia.repository.PessoaRepository;

@RestController
@RequestMapping(value="/barbearia")
public class PessoaController {

	@Autowired
	PessoaRepository pessoaRepositroy;
	
	@CrossOrigin(origins = "http://localhost:8081")
	@GetMapping("/pessoas")
	public List<Pessoa> listaPessoas(){
		return pessoaRepositroy.findAll();
	}
	
	@CrossOrigin(origins = "http://localhost:8081")
	@GetMapping("/pessoa/{id}")
	public Pessoa buscarPessoaId(@PathVariable(value = "id") Long id) {
		return pessoaRepositroy.findByid(id);
	}
	
	@CrossOrigin(origins = "http://localhost:8081")
	@PostMapping("/pessoa")
	 public Pessoa salvaProduto(@RequestBody Pessoa pessoa) {
		return pessoaRepositroy.save(pessoa);
	}
	
}
