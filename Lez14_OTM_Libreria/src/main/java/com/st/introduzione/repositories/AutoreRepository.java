package com.st.introduzione.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.st.introduzione.models.Autore;

@Repository
public interface AutoreRepository extends JpaRepository<Autore, Integer> {

	Autore findByCodice(String codice);
	
	boolean deleteByCodice(String codice);
}
