package com.st.introduzione.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.st.introduzione.models.Autore;
import com.st.introduzione.models.AutoreDTO;
import com.st.introduzione.models.LibroDTO;
import com.st.introduzione.services.AutoreService;

@RestController
@RequestMapping("api/autori")
@CrossOrigin(origins = "*")
public class AutoreController {

	@Autowired
	private AutoreService service;
	
	@GetMapping()
	public ResponseEntity<List<AutoreDTO>> cercaTutti(){
		List<AutoreDTO> elenco = service.cercaTutti();
		
		return ResponseEntity.ok(elenco);
	}
	
	@PostMapping
	public ResponseEntity<AutoreDTO> inserisciLibro(@RequestBody AutoreDTO aDto){
		if(aDto.getCod().isEmpty() || aDto.getNom().isEmpty())
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		
		AutoreDTO dto = this.service.inserisci(aDto);
		if(dto != null) {
			return ResponseEntity.ok(dto);
		}
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
	}
	
	@DeleteMapping("{valCodice}")
	public ResponseEntity<LibroDTO> eliminaLibro(@PathVariable String valCodice) {
		if(service.eliminaPerCodice(valCodice))
			return ResponseEntity.status(HttpStatus.OK).body(null);
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
	
	
}
