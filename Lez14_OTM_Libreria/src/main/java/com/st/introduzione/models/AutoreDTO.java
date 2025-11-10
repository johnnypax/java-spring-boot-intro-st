package com.st.introduzione.models;

import java.util.List;

public class AutoreDTO {
	private String nom;
	private String bio;
	private String cod;
	private List<Libro> elencoLibri;
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	public String getCod() {
		return cod;
	}
	public void setCod(String cod) {
		this.cod = cod;
	}
	public List<Libro> getElencoLibri() {
		return elencoLibri;
	}
	public void setElencoLibri(List<Libro> elencoLibri) {
		this.elencoLibri = elencoLibri;
	}
	
	
}
