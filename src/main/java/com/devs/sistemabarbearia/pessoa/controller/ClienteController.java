package com.devs.sistemabarbearia.pessoa.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devs.sistemabarbearia.dto.ClienteDTO;
import com.devs.sistemabarbearia.model.Cliente;
import com.devs.sistemabarbearia.service.ClienteService;

@RestController
@RequestMapping(value="/barbearia")
//@CrossOrigin(origins ="*" )
public class ClienteController {

	
	@Autowired
	ClienteService clienteService;

	@GetMapping("/clientes")
	public List<ClienteDTO> listaClientes(){
		List<Cliente> list = clienteService.buscarTodos();
		List<ClienteDTO> listDTO =  list.stream().map( cliente-> new ClienteDTO(cliente)).collect(Collectors.toList());
		return listDTO;
	}
	

	
	@GetMapping("/cliente/{id}")
	public Cliente buscarPessoaId(@PathVariable(value = "id") Long id) {
		return clienteService.buscarPorId(id);
	}
	
	@PostMapping("/cliente")
	 public Cliente salvaProduto(@RequestBody Cliente pessoa) {
		return clienteService.salvarCliente(pessoa);
	}
	
	@DeleteMapping("/cliente")
	 public void deletaPessoa(@RequestBody Cliente pessoa) {
		clienteService.excluir(pessoa);	
	}
	
	@PutMapping("/cliente")
	public Cliente update(@RequestBody Cliente pessoa) {
		return clienteService.atualizar(pessoa);
	}
	
	
	
}






























