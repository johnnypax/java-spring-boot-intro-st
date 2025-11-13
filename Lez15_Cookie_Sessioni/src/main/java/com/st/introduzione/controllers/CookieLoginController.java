package com.st.introduzione.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("api")
public class CookieLoginController {

	@GetMapping("login")			// api/login?user=Giovanni&pass=1234
	public String effettuaLogin(
			@RequestParam(name="user") String varUser,
			@RequestParam(name="pass") String varPass,
			HttpServletResponse response) {
		
		if(varUser.equals("utente") && varPass.equals("1234")) {
			Cookie role = new Cookie("ruolo", "USER");
			response.addCookie(role);
			return "Sei un utente semplice";
		}

		if(varUser.equals("admin") && varPass.equals("4321")) {
			Cookie role = new Cookie("ruolo", "ADMIN");
			response.addCookie(role);
			return "Sei un superutente";
		}
		
		return "Non autorizzato";
		
	}
	
	@GetMapping("profilo")
	public String profiloUtente(HttpServletRequest request) {
		
		Cookie[] elenco = request.getCookies();
		
		if(elenco != null) {
			for(Cookie c: elenco) {
				if(c.getName().equals("ruolo") && c.getValue().equals("USER"))
					return "PROFILO UTENTE, Benvenuto ;)";

				if(c.getName().equals("ruolo") && c.getValue().equals("ADMIN"))
					return "PROFILO ADMIN, Puoi fare tutto!";
			}
		}
		
		return "NON SEI AUTORIZZATO";
		
	}
	
}
