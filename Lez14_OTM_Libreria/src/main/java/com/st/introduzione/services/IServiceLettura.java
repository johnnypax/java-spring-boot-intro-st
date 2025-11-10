package com.st.introduzione.services;

import java.util.List;

public interface IServiceLettura<T> {
	
	List<T> cercaTutti();
	
	T cercaPerId(Integer id);

}
