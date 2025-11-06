package com.st.introduzione.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.st.introduzione.models.Carta;
import com.st.introduzione.repositories.CartaRepository;

@RestController
@RequestMapping("api/carta")
public class CartaController {
	
	@Autowired
	private CartaRepository repo;

	@GetMapping("{varId}")
	public Carta getMethodName(@PathVariable Integer varId) {
		return repo.findById(varId).orElse(null);
	}
	
	
}
