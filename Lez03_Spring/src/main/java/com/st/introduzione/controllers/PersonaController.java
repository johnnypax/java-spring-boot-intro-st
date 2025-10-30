package com.st.introduzione.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.st.introduzione.models.Persona;

@RestController
@RequestMapping("persona")
public class PersonaController {

	@GetMapping("dettaglio")
	public Persona restituisciPersona() {
		Persona per = new Persona("Giovanni", "Pace", 39);
		
		return per;
	}
	
	@GetMapping("nuova")
	public Persona nuova(
			@RequestParam String nome,
			@RequestParam String cognome,
			@RequestParam Integer eta
			) {
		Persona per = new Persona(nome, cognome, eta);
		
		return per;
	}
	
	@PostMapping("nuova")
	public Persona nuova(@RequestBody Persona per) {
		return per;
	}
	
	@GetMapping("elenco")
	public List<Persona> elencoPersone(){
		List<Persona> elenco = new ArrayList<Persona>();
		
		elenco.add(new Persona("Giovanni", "Pace", 39));
		elenco.add(new Persona("Valeria", "Verdi", 32));
		elenco.add(new Persona("Marika", "Mariko", 33));
		
		return elenco;
	}
	
}
