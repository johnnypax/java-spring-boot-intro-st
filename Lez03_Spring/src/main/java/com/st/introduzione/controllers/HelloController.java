package com.st.introduzione.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class HelloController {
	
	@GetMapping("saluta")
	public String saluta() {
		return "Ciao Giovanni";
	}
	
	@GetMapping("numero")
	public Float numero() {
		return 18.5f;
	}

	@GetMapping("saluta/{valNome}")
	public String salutaPersona(@PathVariable String valNome) {
		System.out.println("Hai invocato salutaPersona");
		return "Ciao " + valNome;
	}	

	@GetMapping("saluta/{valNome}/{valEta}")
	public String salutaPersona(@PathVariable String valNome, @PathVariable Integer valEta) {
		System.out.println("Hai invocato salutaPersona Secondo");
		return "Ciao " + valNome + " età: " + valEta;
	}
	
	@GetMapping("saluta/parametri")
	public String salutaConParametri(
			@RequestParam(name="nome") String varNome,
			@RequestParam(name="cognome")String varCognome,
			@RequestParam(name="eta") Integer varEta
			) {
		return "Ciao " + varNome + " " + varCognome + " età: " + varEta;
	}
	
	@GetMapping("salutami")					//GETsalutami
	public String salutaGet() {				//String salutaGet()
		return "Ciao da GET";
	}
	
	@PostMapping("salutami")				//POSTsalutami
	public String salutaPost() {			//String salutaPost()
		return "Ciao da POST";
	}
	
}