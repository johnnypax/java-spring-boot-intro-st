package com.st.introduzione.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.st.introduzione.models.Libro;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Integer> {

	Libro findByIsbn(String isbn);
	
	boolean deleteByIsbn(String isbn);
	
}
