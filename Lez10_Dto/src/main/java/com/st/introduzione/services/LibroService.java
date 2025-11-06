package com.st.introduzione.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.introduzione.models.Libro;
import com.st.introduzione.models.LibroDTO;
import com.st.introduzione.repositories.LibroRepository;
import com.st.introduzione.utils.Mappers;

@Service
public class LibroService implements IService<LibroDTO> {

	@Autowired
	private LibroRepository repo;
	
	@Override
	public List<LibroDTO> cercaTutti() {
		List<Libro> elenco = repo.findAll();
		List<LibroDTO> elencoDto = new ArrayList<LibroDTO>();
		
		for(int i=0; i<elenco.size(); i++) {
			Libro l = elenco.get(i);
			
			elencoDto.add(Mappers.libroToDto(l));
		}
		
		return elencoDto;
	}

	@Override
	public LibroDTO cercaPerId(Integer id) {
//		return repo.findById(id).orElse(null);
		return null;
	}

	@Override
	public LibroDTO inserisci(LibroDTO t) {
		
		Libro l = Mappers.dtoToLibro(t);
		LibroDTO risp = null;
		
		if(l != null) {
			l = repo.save(l);
			risp = Mappers.libroToDto(l);
		}
		return risp;
	}

	@Override
	public boolean modifica(LibroDTO t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean elimina(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public LibroDTO cercaPerIsbn(String isbn) {
		Libro lib = repo.findByIsb(isbn).orElse(null);
		
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

}
