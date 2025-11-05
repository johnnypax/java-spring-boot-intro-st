package com.st.introduzione.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.st.introduzione.models.Prodotto;
import com.st.introduzione.services.ProdottoService;

@RestController
@RequestMapping("api/prodotto")
public class ProdottoController {

	@Autowired
	private ProdottoService service;
	
	@GetMapping
	public ResponseEntity<List<Prodotto>> restituisciTutti(){
		List<Prodotto> elenco = service.recuperaProdotti();
		return ResponseEntity.ok(elenco);
	}
	
	@GetMapping("{valId}")
	public ResponseEntity<Prodotto> restituisciProdotto(@PathVariable Integer valId){
		Prodotto pro = service.recuperaSingolo(valId);
		
		if(pro != null)
			return ResponseEntity.ok(pro);
		else
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
	
	@GetMapping("codice/{valCod}")
	public ResponseEntity<Prodotto> cercaPerCodice(@PathVariable String valCod){
		Prodotto pro = service.recuperPerCodice(valCod);
		
		if(pro != null)
			return ResponseEntity.ok(pro);
		else
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
}
