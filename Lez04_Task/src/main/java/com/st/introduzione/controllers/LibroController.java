package com.st.introduzione.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.st.introduzione.models.Libro;

@RestController
@RequestMapping("api/libri")
public class LibroController {

	private List<Libro> elenco = new ArrayList<Libro>();
	
	public LibroController() {
		System.out.println("Ho invocato il costruttore");
	}
	
	@GetMapping
	public ResponseEntity<List<Libro>> restituisciTutti(){
		return ResponseEntity.ok(elenco);
	}
	
	@PostMapping
	public ResponseEntity<Libro> inserisciLibro(@RequestBody Libro lib) {
		if(lib.getTitolo().isBlank())
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		
		lib.setId(this.elenco.size() + 1);
		elenco.add(lib);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(lib);
	}
	
	@GetMapping("{valIsbn}")
	public ResponseEntity<Libro> ricercaLibro(@PathVariable String valIsbn) {
		for(int i=0; i<this.elenco.size(); i++) {
			Libro lib = this.elenco.get(i);
			if(lib.getIsbn().equals(valIsbn)) {
				return ResponseEntity.ok(lib);
			}
		}
		
		return ResponseEntity
				.status(HttpStatus.NOT_FOUND)
				.build();
	}
	
	@DeleteMapping("{valIsbn}")
	public ResponseEntity<Object> eliminaLibro(@PathVariable String valIsbn){
		for(int i=0; i<this.elenco.size(); i++) {
			Libro lib = this.elenco.get(i);
			if(lib.getIsbn().equals(valIsbn)) {
				this.elenco.remove(i);
				return ResponseEntity.status(HttpStatus.OK).build();
			}
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@PutMapping("{valIsbn}")
	public ResponseEntity<Libro> modificaLibro(
			@PathVariable String valIsbn, @RequestBody Libro newLibro){
		
		for(int i=0; i<this.elenco.size(); i++) {
			Libro lib = this.elenco.get(i);
			if(lib.getIsbn().equals(valIsbn)) {
				if(newLibro.getTitolo() != null && !newLibro.getTitolo().isBlank())
					lib.setTitolo( newLibro.getTitolo() );

				if(newLibro.getAutore() != null && !newLibro.getAutore().isBlank())
					lib.setAutore( newLibro.getAutore() );

				if(!(newLibro.getPrezzo() == 0))
					lib.setPrezzo( newLibro.getPrezzo() );
				
				return ResponseEntity.status(HttpStatus.OK).build();
			}
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		
	}
	
}
