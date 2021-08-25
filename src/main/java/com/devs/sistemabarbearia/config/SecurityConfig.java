package com.devs.sistemabarbearia.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.devs.sistemabarbearia.security.JWTUtil;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private JWTUtil jwtUtil;
	
	
	private static final String[] PUBLIC_MATCHERS = {
			"/barbearia/servicos/**"
	};
	
	private static final String[] PUBLIC_MATCHERS_GET = {
			"/barbearia/barbeiro/**",
			"/barbearia/barbeiros/**",
			"/barbearia/pessoa/**",
			"/barbearia/servicos/**",
			"/**"
	};
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.cors().configurationSource( request -> new CorsConfiguration().applyPermitDefaultValues())
		.and().csrf().disable();
		http.authorizeRequests()
		.antMatchers(PUBLIC_MATCHERS_GET).permitAll();
		//			.antMatchers(PUBLIC_MATCHERS_GET).permitAll()
//			.anyRequest().authenticated();
//		http.addFilter(new JWTAutheticationFilter(authenticationManager(), jwtUtil ));
//		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		
	}
	
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
	}
	
//	@Bean
//	CorsConfigurationSource corsConfigurationSource() {
//		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//		source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
//		return (CorsConfigurationSource) source;
//	}
//	
	
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("GET","POST", "OPTIONS"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
   }

	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
}



