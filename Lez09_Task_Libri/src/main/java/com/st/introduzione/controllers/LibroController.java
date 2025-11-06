package com.st.introduzione.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.st.introduzione.models.Libro;
import com.st.introduzione.services.LibroService;

@RestController
@RequestMapping("api/libri")
public class LibroController {
	
	@Autowired
	private LibroService service;

	@GetMapping
	public ResponseEntity<List<Libro>> restituisciTutti(){
		return ResponseEntity.ok(service.cercaTutti());
	}
	
//	@GetMapping("{valId}")
//	public ResponseEntity<Libro> restituisciLibro(@PathVariable Integer valId){
//		Libro l = service.cercaPerId(valId);
//		if(l != null)
//			return ResponseEntity.ok(l);
//		
//		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//	}
	
	@GetMapping("{valIsbn}")
	public ResponseEntity<Libro> restituisciLibroPerIsbn(@PathVariable String valIsbn){
		Libro l = service.cercaPerIsbn(valIsbn);
		if(l != null)
			return ResponseEntity.ok(l);
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
	
	@PostMapping
	public ResponseEntity<Libro> inserisciLibro(@RequestBody Libro lib){
		if(lib.getTit().isBlank() || lib.getIsb().isBlank())
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		
		Libro l = service.inserisci(lib);
		return ResponseEntity.ok(l);
	}
}










