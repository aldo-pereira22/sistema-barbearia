package com.devs.sistemabarbearia;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.devs.sistemabarbearia.model.Barbeiro;
import com.devs.sistemabarbearia.model.Horario;
import com.devs.sistemabarbearia.model.Servico;
import com.devs.sistemabarbearia.model.enums.Perfil;
import com.devs.sistemabarbearia.pessoa.repository.BarbeiroRepository;
import com.devs.sistemabarbearia.pessoa.repository.ServicoRepository;

@SpringBootApplication
public class SistemaBarbeariaApplication implements CommandLineRunner {

	
	@Autowired
	BarbeiroRepository br;
	
	@Autowired
	BCryptPasswordEncoder bc;
	
	@Autowired
	ServicoRepository sr;
	
	public static void main(String[] args) {
		SpringApplication.run(SistemaBarbeariaApplication.class, args);
	}
	
	
	@Override
	public void run(String... args) throws Exception {

			Barbeiro b1 = new Barbeiro(null, "11111", "Aldo","aldo@gmail.com", bc.encode("1234"));
			Barbeiro b2 = new Barbeiro(null, "22222", "João", "joao@gmail.com", bc.encode("1234"));
			Barbeiro b3 = new Barbeiro(null, "22222", "BARBEIRO ADMIN", "barbeiro-admin@gmail.com", bc.encode("1234"));
			
			b3.addPerfil(Perfil.ADMIM);
	
			
			Servico s1 = new Servico(null, "CORTE DE CABELO", 15.25, 30);
			Servico s2 = new Servico(null, "SOBRANCELHA", 10.50, 30);
			Servico s3 = new Servico(null, "PROGRESSIVA", 50.89, 20);
			
			b1.getServicos().addAll(Arrays.asList(s1, s2, s3));
			b2.getServicos().addAll(Arrays.asList(s2));

			s1.getBarbeiros().addAll(Arrays.asList(b1));
			s2.getBarbeiros().addAll(Arrays.asList(b1,b2));
			s3.getBarbeiros().addAll(Arrays.asList(b1));
			
			br.saveAll(Arrays.asList(b1, b2,b3));
			sr.saveAll(Arrays.asList(s1, s2,s3));
	
		
	}

}
