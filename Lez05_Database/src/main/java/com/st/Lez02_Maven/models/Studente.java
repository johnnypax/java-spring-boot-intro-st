package com.st.Lez02_Maven.models;

public class Studente {

	private Integer id;
	private String nom;
	private String cog;
	private String mat;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getCog() {
		return cog;
	}
	public void setCog(String cog) {
		this.cog = cog;
	}
	public String getMat() {
		return mat;
	}
	public void setMat(String mat) {
		this.mat = mat;
	}
	@Override
	public String toString() {
		return "Studente [id=" + id + ", nom=" + nom + ", cog=" + cog + ", mat=" + mat + "]";
	}
	
	
	
	
}
