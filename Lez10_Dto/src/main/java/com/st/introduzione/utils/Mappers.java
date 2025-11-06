package com.st.introduzione.utils;

import com.st.introduzione.models.Libro;
import com.st.introduzione.models.LibroDTO;

public class Mappers {

	public static LibroDTO libroToDto(Libro lib) {
		LibroDTO dto = null;
		
		if(lib != null) {
			dto = new LibroDTO();
			dto.setTitolo( lib.getTit() );
			dto.setAutore( lib.getAut() );
			dto.setAnno( lib.getAnn() );
			dto.setPrezzo( lib.getPre() );
			dto.setIsbn( lib.getIsb() );
		}
		
		return dto;
	}
	
	public static Libro dtoToLibro(LibroDTO dto) {
		Libro lib = null;
		
		if(dto != null) {
			lib = new Libro();
			lib.setTit( dto.getTitolo() );
			lib.setAut( dto.getAutore() );
			lib.setAnn( dto.getAnno() );
			lib.setPre( dto.getPrezzo() );
			lib.setIsb( dto.getIsbn() );
		}
		
		return lib;
	}
	
}
