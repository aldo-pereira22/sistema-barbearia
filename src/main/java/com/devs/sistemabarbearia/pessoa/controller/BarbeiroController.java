package com.devs.sistemabarbearia.pessoa.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.devs.sistemabarbearia.model.Barbeiro;
import com.devs.sistemabarbearia.pessoa.repository.BarbeiroRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping(value="/barbearia")
//@CrossOrigin(origins ="*" )
public class BarbeiroController {

	@Autowired
	BarbeiroRepository barbeiroRepository;
	

	@GetMapping("/barbeiros")
	public List<Barbeiro> listaBarbeiros(){
		return barbeiroRepository.findAll();
	}
	
	@GetMapping("/barbeiro/{id}")
	public Barbeiro buscaBarbeiroId(@PathVariable(value = "id") Long id) throws ObjectNotFoundException {
		
		Barbeiro barbeiro = barbeiroRepository.findByid(id);
		if(barbeiro == null) {
			throw new ObjectNotFoundException("Barbeiro com ID: "+id+ " Não encontrado!");
		}
		
		return barbeiro;
	}
	
	@PostMapping("/barbeiro")
	 public ResponseEntity<?> salvarBarbeiro(@RequestBody Barbeiro barbeiro) {
		barbeiro = barbeiroRepository.save(barbeiro);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(barbeiro.getId()).toUri();
		return ResponseEntity.created(uri).build(); 
	}
	
	@DeleteMapping("/barbeiro")
	 public void deletaPessoa(@RequestBody Barbeiro barbeiro) {
		barbeiroRepository.delete(barbeiro);	
	}
	
	@PutMapping("/barbeiro")
	public Barbeiro update(@RequestBody Barbeiro barbeiro) {
		return barbeiroRepository.save(barbeiro);
	}
	
	
	
}






























