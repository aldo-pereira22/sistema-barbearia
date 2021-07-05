package com.devs.sistemabarbearia;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devs.sistemabarbearia.model.Barbeiro;
import com.devs.sistemabarbearia.model.Servico;
import com.devs.sistemabarbearia.pessoa.repository.BarbeiroRepository;
import com.devs.sistemabarbearia.pessoa.repository.ServicoRepository;

@SpringBootApplication
public class SistemaBarbeariaApplication implements CommandLineRunner {

	
	@Autowired
	BarbeiroRepository br;
	
	@Autowired
	ServicoRepository sr;
	
	public static void main(String[] args) {
		SpringApplication.run(SistemaBarbeariaApplication.class, args);
	}
	
	
	@Override
	public void run(String... args) throws Exception {

			Barbeiro barbeiro = new Barbeiro(null, "1111", "Aldo","aldo@gmail.com", "123", "BARBEIRO");
			Servico servico = new Servico(null, "CORTE DE CABELO",20.50, 20);
			
			sr.save(servico);
			br.save(barbeiro);
			
			barbeiro.getServicos().addAll(Arrays.asList(servico));
			servico.getBarbeiros().add(barbeiro);
			
		
		
	}

}
