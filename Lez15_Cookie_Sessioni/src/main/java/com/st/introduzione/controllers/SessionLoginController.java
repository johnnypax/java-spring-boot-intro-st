package com.st.introduzione.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;


@RestController
@RequestMapping("api/sessioni")
public class SessionLoginController {

	@GetMapping("login")
	public String login(
			@RequestParam String user, 
			@RequestParam String pass,
			HttpServletRequest request) {
		
		HttpSession sessione = request.getSession();
		
		if(user.equals("utente") && pass.equals("1234")) {
			sessione.setAttribute("ruolo", "USER");
			return "Sei un utente";
		}
		
		if(user.equals("admin") && pass.equals("4321")) {
			sessione.setAttribute("ruolo", "ADMIN");
			return "Sei un amministratore";
		}
		
		return "Mi dispiace non sei autorizzato!";
		
	}
	
	@GetMapping("profilo")
	public String profilo(HttpServletRequest request) {
		HttpSession sessione = request.getSession();
		
		try {
			switch ((String)sessione.getAttribute("ruolo")) {
				case "USER": 
					return "profilo utente!";
				case "ADMIN": 
					return "profilo amministratore!";
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return "non autorizzato";
	}
	
}
