package com.st.introduzione.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.st.introduzione.models.Persona;
import com.st.introduzione.models.PersonaDTO;
import com.st.introduzione.repositories.PersonaRepository;
import com.st.introduzione.services.PersonaService;

@RestController
@RequestMapping("api/persona")
public class PersonaController {

	@Autowired
	private PersonaService service;
	
	@GetMapping("{valId}")
	public PersonaDTO cercaPersona(@PathVariable Integer valId) {
		return service.cercaPerId(valId);
	}
	
	@GetMapping("{valId}/dettaglio")
	public PersonaDTO cercaPersonaDettagliato(@PathVariable Integer valId) {
		return service.cercaPerIdDettagliato(valId);
	}
	
}
