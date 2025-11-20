package com.st.introduzione.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.st.introduzione.models.UserLoginRequest;
import com.st.introduzione.services.JwtService;
import com.st.introduzione.services.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private JwtService jwtService;

	@PostMapping("login")
	public ResponseEntity<?> login(@RequestBody UserLoginRequest utente){
		
		if(!userService.validazioneUtente(utente.getUsername(), utente.getPassword()))
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
		
		String token = this.jwtService.generateToken(utente.getUsername()); 
		
		return ResponseEntity.ok(Map.of("token", token));
	}
	
	@GetMapping("profilo")
	public ResponseEntity<?> profilo(){
		return ResponseEntity.ok("Accesso autorizzato al tuo profilo");
	}
	
}
