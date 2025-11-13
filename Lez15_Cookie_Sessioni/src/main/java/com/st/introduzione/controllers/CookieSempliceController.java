package com.st.introduzione.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("api/cookie/semplici")
public class CookieSempliceController {

	@GetMapping("emetti")
	public String generaCookie(HttpServletResponse response) {
		
		Cookie linguaggio = new Cookie("lang", "ENG");
		Cookie modalita = new Cookie("mode", "DARK");
		
		response.addCookie(linguaggio);
		response.addCookie(modalita);
		
		return "Ciao Giovanni";
	}
	
	@GetMapping("leggi")
	public String leggiCookie(HttpServletRequest request) {
		
		Cookie[] cookies = request.getCookies();
		
		if(cookies != null) {
			
			for(Cookie c: cookies) {
				System.out.println(c.getName() + " " + c.getValue());
				
				if(c.getName().equals("lang") && c.getValue().equals("ENG"))
					return "Hellooooooo";

				if(c.getName().equals("lang") && c.getValue().equals("ITA"))
					return "Ciaoooooooo";
			}
			
		}
		
		return "Aribenvenuto";
	}
	
	
}
