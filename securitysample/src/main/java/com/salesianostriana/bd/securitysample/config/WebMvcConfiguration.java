package com.salesianostriana.bd.securitysample.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 
 * @author Luismi
 * 
 * En aquellos casos en los que los controladores no tienen nada de
 * "lógica", y tan solo sirven para enviarnos a una plantilla,
 * podemos usar el método addViewControllers, que nos permite
 * hacer todo esto en una sola línea.
 * 
 */
@Configuration
@EnableWebMvc
@ComponentScan
public class WebMvcConfiguration implements WebMvcConfigurer {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/login").setViewName("login.html");
	}

}
