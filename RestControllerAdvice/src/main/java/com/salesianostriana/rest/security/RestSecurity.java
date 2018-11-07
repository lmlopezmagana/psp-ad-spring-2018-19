package com.salesianostriana.rest.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;

@Configuration
@EnableWebSecurity
public class RestSecurity extends WebSecurityConfigurerAdapter {

	@Autowired
	private BasicAuthenticationEntryPoint aEntryPoint;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		// @formatter:off
		auth
			.inMemoryAuthentication()
			.passwordEncoder(NoOpPasswordEncoder.getInstance())
			.withUser("admin").password("admin").roles("ADMIN", "USER");
		 
		// @formatter:on

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		// @formatter:off
		http
			.csrf().disable()
			.authorizeRequests().anyRequest().authenticated()
			.and()
			.httpBasic()
				.authenticationEntryPoint(aEntryPoint);
		// @formatter:on

	}
	
	

}
