package com.st.introduzione.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.st.introduzione.models.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer> {

}
