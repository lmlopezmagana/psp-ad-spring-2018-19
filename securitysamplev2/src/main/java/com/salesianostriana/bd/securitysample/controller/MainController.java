package com.salesianostriana.bd.securitysample.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/*
 * Un controlador como otro cualquiera. Es al que la aplicación nos redirige
 * cuando tenemos éxito en el login.
 */
@Controller
public class MainController {
	
	/**
	 * 
	 * @param model El modelo mediante el cual pasamos datos a la plantilla
	 * @param principal Un objeto de tipo Principal generalmente hacer referencia a un usuario dispositivo u otro sistema que puede realizar una acción en una aplicación.
	 * @return La plantilla a la que nos redirige
	 */
	@GetMapping("/")
	public String index(Model model, Principal principal) {
		model.addAttribute("message", "You are logged in as " + principal.getName());
	    return "homepage";
	}

}
