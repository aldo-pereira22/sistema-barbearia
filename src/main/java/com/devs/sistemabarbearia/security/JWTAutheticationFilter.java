package com.devs.sistemabarbearia.security;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.devs.sistemabarbearia.dto.CredenciaisDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JWTAutheticationFilter  extends UsernamePasswordAuthenticationFilter{

	@Autowired
	private AuthenticationManager authentication;
	
	
	@Autowired
	private JWTUtil jwtUtil;
	

	
	public JWTAutheticationFilter(AuthenticationManager authenticationManager, JWTUtil jwtUtil  ) {
		this.authentication = authenticationManager;
		this.jwtUtil = jwtUtil;		
	}
	
	
	public Authentication attempAuthentication(HttpServletRequest req,
												HttpServletResponse res
					)throws AuthenticationException{
		
		try {
			CredenciaisDTO creds = new ObjectMapper()
					.readValue(req.getInputStream(), CredenciaisDTO.class);
			UsernamePasswordAuthenticationToken authToken =  new UsernamePasswordAuthenticationToken(creds.getEmail(), creds.getSenha(), new ArrayList<>());
			
			Authentication auth = authentication.authenticate(authToken);
			return auth;
			
		} catch (IOException e) {
			throw new RuntimeException("Falha ao autenticar! ");
		}
		
	}

	
	@Override
    protected void successfulAuthentication(HttpServletRequest req,
                                            HttpServletResponse res,
                                            FilterChain chain,
                                            Authentication auth) throws IOException, ServletException {	 
	

		String username = ((UserSS) auth.getPrincipal()).getUsername();
		String token = jwtUtil.generateToken(username);
		res.addHeader("Authorization", "Bearer" + token);
		
	}

	
	
}
