package com.st.introduzione.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="personaID")
	private Integer id;
	@Column
	private String nominativo;
	@Column
	private String email;
	
	@OneToMany(mappedBy = "proprietario",
			cascade = CascadeType.REMOVE,
			fetch = FetchType.LAZY)
	@JsonManagedReference
	private List<Carta> elencoCarte;
	
	public Persona() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNominativo() {
		return nominativo;
	}

	public void setNominativo(String nominativo) {
		this.nominativo = nominativo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Carta> getElencoCarte() {
		return elencoCarte;
	}

	public void setElencoCarte(List<Carta> elencoCarte) {
		this.elencoCarte = elencoCarte;
	}
	
	
	
}
