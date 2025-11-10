package com.st.introduzione.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name="Autori")
public class Autore {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="autoreID")
	private Integer id;
	@Column
	private String nome;
	@Column
	private String bio;
	@Column
	private String codice;
	
	@Transient
	private List<Libro> elencoLibri;
	
	public Autore() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public List<Libro> getElencoLibri() {
		return elencoLibri;
	}

	public void setElencoLibri(List<Libro> elencoLibri) {
		this.elencoLibri = elencoLibri;
	}
	
	
	
	
}
