package com.st.introduzione.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="libri")
public class Libro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="libroID")
	private Integer 	id;
	@Column(name="titolo")
	private String 		tit;
	@Column(name="autore")
	private String 		aut;
	@Column(name="anno")
	private Integer 	ann;
	@Column(name="prezzo")
	private Float 		pre;
	@Column(name="isbn")
	private String 		isb;
	
	public Libro() {
		
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTit() {
		return tit;
	}
	public void setTit(String tit) {
		this.tit = tit;
	}
	public String getAut() {
		return aut;
	}
	public void setAut(String aut) {
		this.aut = aut;
	}
	public Integer getAnn() {
		return ann;
	}
	public void setAnn(Integer ann) {
		this.ann = ann;
	}
	public Float getPre() {
		return pre;
	}
	public void setPre(Float pre) {
		this.pre = pre;
	}
	public String getIsb() {
		return isb;
	}
	public void setIsb(String isb) {
		this.isb = isb;
	}
	
	
	
	
}
