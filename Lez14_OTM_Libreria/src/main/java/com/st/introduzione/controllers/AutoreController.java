package com.st.introduzione.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.st.introduzione.models.Autore;
import com.st.introduzione.services.AutoreService;

@RestController
@RequestMapping("api/autori")
public class AutoreController {

	private AutoreService service;
	
	
}
