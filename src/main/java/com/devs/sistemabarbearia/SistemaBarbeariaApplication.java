package com.devs.sistemabarbearia;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.devs.sistemabarbearia.model.Barbeiro;
import com.devs.sistemabarbearia.model.Cliente;
import com.devs.sistemabarbearia.model.ReservaDeServico;
import com.devs.sistemabarbearia.model.Servico;
import com.devs.sistemabarbearia.model.enums.Perfil;
import com.devs.sistemabarbearia.pessoa.repository.BarbeiroRepository;
import com.devs.sistemabarbearia.pessoa.repository.ServicoRepository;
import com.devs.sistemabarbearia.service.ClienteService;
import com.devs.sistemabarbearia.service.ReservaServicoService;

@SpringBootApplication
public class SistemaBarbeariaApplication implements CommandLineRunner {

	
	@Autowired
	BarbeiroRepository br;
	
	@Autowired
	ReservaServicoService rs;
	
	@Autowired
	BCryptPasswordEncoder bc;
	
	@Autowired
	ServicoRepository sr;
	
	@Autowired
	ClienteService cs;
	
	public static void main(String[] args) {
		SpringApplication.run(SistemaBarbeariaApplication.class, args);
	}
	
	
	@Override
	public void run(String... args) throws Exception {

			Barbeiro b1 = new Barbeiro(null, "11111", "Aldo","aldo@gmail.com", bc.encode("1234"));
			Barbeiro b2 = new Barbeiro(null, "22222", "João", "joao@gmail.com", bc.encode("1234"));
			Barbeiro b3 = new Barbeiro(null, "22222", "BARBEIRO ADMIN", "barbeiro-admin@gmail.com", bc.encode("1234"));
			
			Servico s1 = new Servico(null, "CORTE DE CABELO", 15.25, 30);
			Servico s2 = new Servico(null, "SOBRANCELHA", 10.50, 30);
			Servico s3 = new Servico(null, "PROGRESSIVA", 50.89, 20);
			
			
		
			Cliente cliente = new Cliente(
					null, "1111", "Marcos", "marcos-@gmail.com","1234");			
			
		
			
			ReservaDeServico reserva = new ReservaDeServico();
			
			
			cliente.addReserva(reserva);
			
			cs.salvarCliente(cliente);
//			cs.excluir(cliente);
			


		
		
			

//			rs.salvar(reserva);
//			cliente.getReservas().addAll(Arrays.asList(reserva));
			
		
			b3.addPerfil(Perfil.ADMIM);
			
	
			
			

			
			b1.getServicos().addAll(Arrays.asList(s1, s2, s3));
			b2.getServicos().addAll(Arrays.asList(s2));

			s1.getBarbeiros().addAll(Arrays.asList(b1));
			s2.getBarbeiros().addAll(Arrays.asList(b1,b2));
			s3.getBarbeiros().addAll(Arrays.asList(b1));
			
			br.saveAll(Arrays.asList(b1, b2,b3));
			sr.saveAll(Arrays.asList(s1, s2,s3));
			reserva.setServicos(s1);
			rs.salvar(reserva);
			rs.delete(reserva);
			System.out.println("\n\n\n\n");
	
			Barbeiro barbeiro = br.findByEmail("aldo@gmail.com");
			System.out.println("Barbbeiro : "+barbeiro.getNome());
			System.out.println("Email : "+barbeiro.getEmail());
		
	}

}
