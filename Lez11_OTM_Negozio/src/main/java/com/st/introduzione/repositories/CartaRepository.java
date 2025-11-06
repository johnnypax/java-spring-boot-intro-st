package com.st.introduzione.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.st.introduzione.models.Carta;

@Repository
public interface CartaRepository extends JpaRepository<Carta, Integer>{

}
