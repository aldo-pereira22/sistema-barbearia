package com.devs.sistemabarbearia.pessoa.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.devs.sistemabarbearia.model.Agenda;
import com.devs.sistemabarbearia.model.Barbeiro;
import com.devs.sistemabarbearia.service.AgendaService;

import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping(value="/barbearia")
//@CrossOrigin(origins ="*" )
public class AgendaController {

	
	@Autowired
	AgendaService service;
	
	
	

	@GetMapping("/agenda")
	public List<Agenda> listaBarbeiros(){		
		return service.findAll();
	}
	
	@GetMapping("/agenda/{id}")
	public Agenda buscarAgendaPorId(@PathVariable(value = "id") Long id) throws ObjectNotFoundException {
		
		Agenda agenda = service.findById(id);
		if(agenda == null) {
			throw new ObjectNotFoundException("Agenda com ID: "+id+ " Não encontrada!");
		}
		
		return agenda;
	}
	
	@PostMapping("/agenda")
	 public Agenda agenda(@RequestBody Agenda agenda) {
		agenda = service.save(agenda);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(agenda.getId()).toUri();
//		return ResponseEntity.created(uri).build(); 
		return service.save(agenda);
	}
	
	@DeleteMapping("/agenda")
	 public void deletaPessoa(@RequestBody Agenda agenda) {
//		barbeiroRepository.delete(barbeiro);
		service.delete(agenda);
		
//		barbeiroService.delete(barbeiro);
	}
	
	@PutMapping("/agenda")
	public Agenda update(@RequestBody Agenda agenda) {
		return service.save(agenda);
	}
	
	
	
}






























