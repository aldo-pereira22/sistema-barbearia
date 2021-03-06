package com.devs.sistemabarbearia;

import java.util.Arrays;import org.apache.tomcat.util.http.ConcurrentDateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.devs.sistemabarbearia.model.Agenda;
import com.devs.sistemabarbearia.model.Barbeiro;
import com.devs.sistemabarbearia.model.Cliente;
import com.devs.sistemabarbearia.model.Horario;
import com.devs.sistemabarbearia.model.HorarioAtendimento;
import com.devs.sistemabarbearia.model.Pagamento;
import com.devs.sistemabarbearia.model.ReservaDeServico;
import com.devs.sistemabarbearia.model.Servico;
import com.devs.sistemabarbearia.model.enums.Perfil;
import com.devs.sistemabarbearia.pessoa.repository.BarbeiroRepository;
import com.devs.sistemabarbearia.pessoa.repository.HorarioAtendimentoRepository;
import com.devs.sistemabarbearia.pessoa.repository.ServicoRepository;
import com.devs.sistemabarbearia.service.AgendaService;
import com.devs.sistemabarbearia.service.BarbeiroService;
import com.devs.sistemabarbearia.service.ClienteService;
import com.devs.sistemabarbearia.service.HorarioService;
import com.devs.sistemabarbearia.service.ReservaServicoService;

@SpringBootApplication
public class SistemaBarbeariaApplication implements CommandLineRunner {

	
	@Autowired
	BarbeiroService br;
	
	@Autowired
	HorarioService hs;
	
	@Autowired
	ReservaServicoService rs;
	
	@Autowired
	BCryptPasswordEncoder bc;
	
	@Autowired
	ServicoRepository sr;
	
	@Autowired
	ClienteService cs;
	
	@Autowired
	AgendaService as;
	
	@Autowired
	HorarioAtendimentoRepository ha;
	public static void main(String[] args) {
		SpringApplication.run(SistemaBarbeariaApplication.class, args);
	}
	
	
	@Override
	public void run(String... args) throws Exception {

			Barbeiro b1 = new Barbeiro(null, "11111", "Aldo","aldo@gmail.com", bc.encode("1234"));
			Barbeiro b2 = new Barbeiro(null, "22222", "Jo??o", "joao@gmail.com", bc.encode("1234"));
			Barbeiro b3 = new Barbeiro(null, "22222", "BARBEIRO ADMIN", "barbeiro-admin@gmail.com", bc.encode("1234"));
			b3.addPerfil(Perfil.ADMIM);
			
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
			
		
	
			
	
			
			

			
			b1.getServicos().addAll(Arrays.asList(s1, s2, s3));
			b2.getServicos().addAll(Arrays.asList(s2));

			s1.getBarbeiros().addAll(Arrays.asList(b1));
			s2.getBarbeiros().addAll(Arrays.asList(b1,b2));
			s3.getBarbeiros().addAll(Arrays.asList(b1));
			
			br.saveAll(Arrays.asList(b1, b2,b3));
			sr.saveAll(Arrays.asList(s1, s2,s3));
			reserva.setServicos(s1);
			rs.salvar(reserva);
//			rs.delete(reserva);
			System.out.println("\n\n\n\n");

			Agenda agenda = new Agenda();
			as.save(agenda);
			
			b3.setAgenda(agenda);
			agenda.setBarbeiro(b3);
			br.save(b3);
			reserva.setAgenda(agenda);
			agenda.getListaDeReservas().addAll(Arrays.asList(reserva));
			rs.salvar(reserva);
			as.save(agenda);
			
			Pagamento pgto = new Pagamento();
			pgto.setReserva(reserva);
			
			reserva.setPagamento(pgto);
			
			HorarioAtendimento horarioAtendimento = new HorarioAtendimento();
			ha.save(horarioAtendimento);
			
			
			agenda.setHorarioAtendimento(horarioAtendimento);
			ha.save(horarioAtendimento);
			as.save(agenda);
			
			agenda.setHorarioAtendimento(null);
			as.save(agenda);
//			as.delete(agenda);

			
//			ha.delete(horarioAtendimento);
			
//			b3.setAgenda(agenda);
//			br.delete(b3);
			
//			rs.delete(reserva);			
//			as.delete(agenda);

	}

}
