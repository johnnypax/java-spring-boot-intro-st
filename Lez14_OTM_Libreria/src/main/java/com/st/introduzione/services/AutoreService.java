package com.st.introduzione.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.introduzione.models.Autore;
import com.st.introduzione.models.AutoreDTO;
import com.st.introduzione.models.Libro;
import com.st.introduzione.models.LibroDTO;
import com.st.introduzione.repositories.AutoreRepository;

@Service
public class AutoreService implements IServiceLettura<AutoreDTO>, IServiceScrittura<AutoreDTO> {

	@Autowired
	private AutoreRepository autRepo;

	@Override
	public List<AutoreDTO> cercaTutti() {
		List<Autore> e = autRepo.findAll();
		List<AutoreDTO> eDto = new ArrayList<AutoreDTO>();
		
		for(int i=0;i<e.size();i++) {
			AutoreDTO dto = new AutoreDTO();
			dto.setNom( e.get(i).getNome() );
			dto.setCod( e.get(i).getCodice() );
			dto.setBio( e.get(i).getBio() );
			
			eDto.add(dto);
		}
		
		return eDto;
	}

	
	
	public AutoreDTO cercaPerCodice(String codice) {
		Autore a = autRepo.findByCodice(codice);
		AutoreDTO dto = null;
		
		if(a != null) {
			dto = new AutoreDTO();
			dto.setNom( a.getNome() );
			dto.setBio( a.getBio() );
			dto.setCod( a.getCodice() );
		}
		
		return dto;
	}
	
	Autore cercaPerCodiceAut(String codice) {
		return autRepo.findByCodice(codice);
	}



	@Override
	public AutoreDTO inserisci(AutoreDTO t) {
		Autore a = new Autore();
		
		if(t != null) {
			a.setNome( t.getNom() );
			a.setCodice( t.getCod() );
			a.setBio( t.getBio() );
			
			autRepo.save(a);
			if(a.getId() != null) {
				AutoreDTO dto = new AutoreDTO();
				dto.setNom( a.getNome() );
				dto.setCod( a.getCodice() );
				dto.setBio( a.getBio() );
				
				return dto;
			}
		}
		
		return null;
	}



	@Override
	public boolean elimina(Integer Id) {
		autRepo.deleteById(Id);
		
		if(autRepo.findById(Id).orElse(null) == null)
			return true;
		
		return false;
	}

	public boolean eliminaPerCodice(String codice) {
		Autore l = autRepo.findByCodice(codice);
		if(l != null) {
			return this.elimina(l.getId());
		}
		
		return false;
	}


	@Override
	public boolean modifica(AutoreDTO t) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public AutoreDTO cercaPerId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
