package com.salesianostriana.bd.securitysample.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	// Servicio que nos permite interactuar con el 
	// "almacén" de usuarios.
	@Autowired
	UserDetailsService userDetailsService;

	// Codificador para la contraseña. En este
	// caso usamos BCryptPasswordEncoder.
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	};

	// Configuración de la autenticación. En este caso,
	// indicamos que será a través de un servicio.
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());		
	}

	
	// Configuración de la autorización.
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		// @formatter:off

		http
			.authorizeRequests()
			.antMatchers("/h2-console/**").permitAll() // Para permitir la consola de H2
			.antMatchers("/login*").permitAll() // Para permitir el acceso al formulario de login
			.anyRequest().authenticated() // El resto de peticiones, autenticadas.
			.and()
			.formLogin() 
				.loginPage("/login") // Ruta del controlador del formulario de login
				.defaultSuccessUrl("/") // Ruta de redirección en caso de éxito.
				.loginProcessingUrl("/login") // Ruta de procesamiento del formulario de login.
				.failureUrl("/login?error=true") // Ruta en caso de error de login.
			.and()
			.logout().logoutSuccessUrl("/login?logout"); // por defecto POST a /logout
		

		// @formatter:on

	}

}
