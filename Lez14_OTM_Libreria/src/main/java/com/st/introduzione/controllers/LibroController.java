package com.st.introduzione.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.st.introduzione.models.LibroDTO;
import com.st.introduzione.services.LibroService;

@RestController
@RequestMapping("api/libri")
@CrossOrigin(origins = "*")
public class LibroController {

	@Autowired
	private LibroService service;
	
	@GetMapping()
	public ResponseEntity<List<LibroDTO>> cercaTutti(){
		List<LibroDTO> elenco = service.cercaTutti();
		
		return ResponseEntity.ok(elenco);
	}
	
	@GetMapping("{valIsbn}")
	public ResponseEntity<LibroDTO> cercaLibro(@PathVariable String valIsbn){
		LibroDTO dto = this.service.cercaPerIsbn(valIsbn);
		if(dto != null)
			return ResponseEntity.ok(dto);
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
	
	@PostMapping
	public ResponseEntity<LibroDTO> inserisciLibro(@RequestBody LibroDTO lDto){
		if(lDto.getAut() == null || lDto.getAut().getCod().isEmpty())
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		
		LibroDTO dto = this.service.inserisci(lDto);
		if(dto != null) {
			return ResponseEntity.ok(dto);
		}
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
	}
	
	@DeleteMapping("{valIsbn}")
	public ResponseEntity<LibroDTO> eliminaLibro(@PathVariable String valIsbn) {
		if(service.eliminaPerIsbn(valIsbn))
			return ResponseEntity.status(HttpStatus.OK).body(null);
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
	
}
