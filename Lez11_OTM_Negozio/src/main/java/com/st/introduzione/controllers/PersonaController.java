package com.st.introduzione.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.st.introduzione.models.Persona;
import com.st.introduzione.repositories.PersonaRepository;

@RestController
@RequestMapping("api/persona")
public class PersonaController {
	
	@Autowired
	private PersonaRepository repo;
	
	@GetMapping("{varId}")
	public Persona cercaPersona(@PathVariable Integer varId) {
		return repo.findById(varId).orElse(null);
	}

}
