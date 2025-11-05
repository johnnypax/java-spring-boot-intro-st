package com.st.introduzione.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.introduzione.models.Prodotto;
import com.st.introduzione.repositories.ProdottoRepository;

@Service
public class ProdottoService {
	
	@Autowired
	private ProdottoRepository repo;
	
	public List<Prodotto> recuperaProdotti(){
		return repo.findAll();
	}
	
	public Prodotto recuperaSingolo(Integer id) {
		return repo.findById(id).orElse(null);
	}
	
	public Prodotto recuperPerCodice(String cod) {
		return repo.findByCodice(cod);
	}
	
}
