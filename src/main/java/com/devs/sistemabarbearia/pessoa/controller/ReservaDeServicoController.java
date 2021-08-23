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

import com.devs.sistemabarbearia.model.ReservaDeServico;
import com.devs.sistemabarbearia.service.ReservaServicoService;

import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping(value="/barbearia")
//@CrossOrigin(origins ="*" )
public class ReservaDeServicoController {

	
	@Autowired
	ReservaServicoService service;
	
	
	

	@GetMapping("/reservas")
	public List<ReservaDeServico> listaBarbeiros(){
		
		return service.findAll();
	}
	
	@GetMapping("/reserva/{id}")
	public ReservaDeServico buscarPorId(@PathVariable(value = "id") Long id) throws ObjectNotFoundException {
		
		ReservaDeServico reserva = service.findById(id);
		if(reserva == null) {
			throw new ObjectNotFoundException("Reserva com ID: "+id+ " Não encontrada!");
		}
		
		return reserva;
	}
	
	@PostMapping("/reserva")
	 public ReservaDeServico salvarReserva(@RequestBody ReservaDeServico reserva) {
		reserva = service.save(reserva);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(reserva.getId()).toUri();
//		return ResponseEntity.created(uri).build(); 
		return service.save(reserva);
	}
	
	@DeleteMapping("/reserva")
	 public void deletaPessoa(@RequestBody ReservaDeServico reserva) {
//		barbeiroRepository.delete(barbeiro);
		service.delete(reserva);
		
//		barbeiroService.delete(barbeiro);
	}
	
	@PutMapping("/reserva")
	public ReservaDeServico update(@RequestBody ReservaDeServico reserva) {
		return service.save(reserva);
	}
	
	
	
}






























