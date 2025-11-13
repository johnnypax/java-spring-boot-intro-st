package com.st.introduzione.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.introduzione.models.Autore;
import com.st.introduzione.models.Libro;
import com.st.introduzione.models.LibroDTO;
import com.st.introduzione.repositories.LibroRepository;

@Service
public class LibroService implements IServiceLettura<LibroDTO>, IServiceScrittura<LibroDTO> {

	@Autowired
	private LibroRepository libRepo;
	
	@Autowired
	private AutoreService autServ;

	@Override
	public List<LibroDTO> cercaTutti() {
		List<Libro> e = libRepo.findAll();
		List<LibroDTO> eDto = new ArrayList<LibroDTO>();
		
		for(int i=0;i<e.size();i++) {
			LibroDTO dto = new LibroDTO();
			dto.setTit( e.get(i).getTitolo() );
			dto.setAnn( e.get(i).getAnno() );
			dto.setIsb( e.get(i).getIsbn() );
			dto.setPre( e.get(i).getPrezzo() ); 
			
			eDto.add(dto);
		}
		
		return eDto;
	}

	@Override
	public LibroDTO cercaPerId(Integer id) {
		return null;
	}
	
	public LibroDTO cercaPerIsbn(String isbn) {
		Libro l = libRepo.findByIsbn(isbn);
		LibroDTO dto = null;
		
		if(l != null) {
			dto = new LibroDTO();
			dto.setTit( l.getTitolo() );
			dto.setAnn( l.getAnno() );
			dto.setIsb( l.getIsbn() );
			dto.setPre( l.getPrezzo() ); 
		}
		
		return dto;
	}

	@Override
	public LibroDTO inserisci(LibroDTO t) {
		Libro l = new Libro();
		
		if(t != null) {
			l.setTitolo( t.getTit() );
			l.setAnno( t.getAnn() );
			l.setIsbn(t.getIsb() );
			l.setPrezzo(t.getPre()); 
			
			Autore aut = autServ.cercaPerCodiceAut( t.getAut().getCod() );
			l.setAutoreRIF(aut.getId());
			
			libRepo.save(l);
			if(l.getId() != null) {
				LibroDTO dto = new LibroDTO();
				dto.setTit( l.getTitolo() );
				dto.setAnn( l.getAnno() );
				dto.setIsb( l.getIsbn() );
				dto.setPre( l.getPrezzo() ); 
				
				return dto;
			}
		}
		
		return null;
	}

	@Override
	public boolean elimina(Integer Id) {
		libRepo.deleteById(Id);
		
		if(libRepo.findById(Id).orElse(null) == null)
			return true;
		
		return false;
	}
	
	public boolean eliminaPerIsbn(String isbn) {
		Libro l = libRepo.findByIsbn(isbn);
		if(l != null) {
			return this.elimina(l.getId());
		}
		
		return false;
	}

	@Override
	public boolean modifica(LibroDTO t) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
}
