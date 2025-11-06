package com.st.introduzione.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.introduzione.models.Libro;
import com.st.introduzione.repositories.LibroRepository;

@Service
public class LibroService implements IService<Libro> {

	@Autowired
	private LibroRepository repo;
	
	@Override
	public List<Libro> cercaTutti() {
		return repo.findAll();
	}

	@Override
	public Libro cercaPerId(Integer id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public Libro inserisci(Libro t) {
		t.setId(null);
		
		return repo.save(t);
	}

	@Override
	public boolean modifica(Libro t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean elimina(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public Libro cercaPerIsbn(String isbn) {
		return repo.findByIsb(isbn).orElse(null);
	}

}
