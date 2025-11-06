package com.st.introduzione.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Carta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cartaID")
	private Integer id;
	@Column
	private String codice;
	@Column
	private String negozio;
	@Column
	private Integer personaRIF;
	
	@ManyToOne
	@JoinColumn(name="personaRIF")
	@JsonBackReference
	private Persona proprietario;
	
	public Carta() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public String getNegozio() {
		return negozio;
	}

	public void setNegozio(String negozio) {
		this.negozio = negozio;
	}

	public Persona getProprietario() {
		return proprietario;
	}

	public void setProprietario(Persona proprietario) {
		this.proprietario = proprietario;
	}
	
	
	
}
