package com.st.introduzione.models;

import java.util.List;

public class PersonaDTO {

	private String nom;
	private String ema;
	private List<CartaDTO> elencoCarte;		//QUando mi serve...
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getEma() {
		return ema;
	}
	public void setEma(String ema) {
		this.ema = ema;
	}
	public List<CartaDTO> getElencoCarte() {
		return elencoCarte;
	}
	public void setElencoCarte(List<CartaDTO> elencoCarte) {
		this.elencoCarte = elencoCarte;
	}
	
	
	
}
