package com.devs.sistemabarbearia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.devs.sistemabarbearia.model.Barbeiro;
import com.devs.sistemabarbearia.pessoa.repository.BarbeiroRepository;
import com.devs.sistemabarbearia.security.UserSS;

@Service
public class UserDetailsImpl implements UserDetailsService{

	@Autowired
	private BarbeiroRepository br;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Barbeiro barbeiro =  br.findByEmail(email);
		
		if(barbeiro == null) {
			throw new UsernameNotFoundException(email);
		}
		
		return new UserSS(barbeiro.getId(), barbeiro.getEmail(), barbeiro.getSenha(), barbeiro.getPerfis());
	}

}
