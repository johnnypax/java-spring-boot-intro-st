package com.st.introduzione.services;

public interface IServiceScrittura<T> {

	T inserisci(T t);
	
	boolean elimina(Integer Id);
	
	boolean modifica(T t);
	
}
