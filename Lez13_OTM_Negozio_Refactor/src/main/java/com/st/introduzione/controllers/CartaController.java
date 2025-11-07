package com.st.introduzione.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.st.introduzione.models.Carta;
import com.st.introduzione.models.CartaDTO;
import com.st.introduzione.repositories.CartaRepository;
import com.st.introduzione.services.CartaService;

@RestController
@RequestMapping("api/carta")
public class CartaController {
	
	@Autowired
	private CartaService carServ;
	
	@GetMapping("{valId}")
	public CartaDTO cercaCartaPerId(@PathVariable Integer valId) {
		return carServ.cercaPerIdConProprietario(valId, false);
	}
	
	@GetMapping("{valId}/dettaglio")
	public CartaDTO cercaCartaPerIdDettagliato(@PathVariable Integer valId) {
		return carServ.cercaPerIdConProprietario(valId, true);
	}
	
}
