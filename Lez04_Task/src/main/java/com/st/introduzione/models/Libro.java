package com.st.introduzione.models;

public class Libro {
	
	private Integer id;
	private String titolo;
	private String autore;
	private float prezzo;
	private String isbn;
	
	public Libro() {
		
	}
	
	public Libro(Integer id, String titolo, String autore, float prezzo, String isbn) {
		super();
		this.id = id;
		this.titolo = titolo;
		this.autore = autore;
		this.prezzo = prezzo;
		this.isbn = isbn;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public String getAutore() {
		return autore;
	}
	public void setAutore(String autore) {
		this.autore = autore;
	}
	public float getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	@Override
	public String toString() {
		return "Libro [id=" + id + ", titolo=" + titolo + ", autore=" + autore + ", prezzo=" + prezzo + ", isbn=" + isbn
				+ "]";
	}
	
	
	
	

}
