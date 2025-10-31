package com.st.Lez02_Maven.models;

import java.util.ArrayList;

public interface InterfaceDAO<T> {

	T findById(int id);
	
	ArrayList<T> findAll();
	
	boolean insert(T t);
	
	boolean update(T t);
	
	boolean delete(T t);
	
}
