package com.st.introduzione.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.st.introduzione.models.Libro;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Integer>{

	Optional<Libro> findByIsb(String i);
	
}
