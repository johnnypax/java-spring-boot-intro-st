package com.st.introduzione.services;

import java.util.List;

public interface IService<T> {

	List<T> cercaTutti();
	
	T cercaPerId(Integer id);
	
	T inserisci(T t);
	
	boolean modifica(T t);
	
	boolean elimina(Integer id);
	
}
