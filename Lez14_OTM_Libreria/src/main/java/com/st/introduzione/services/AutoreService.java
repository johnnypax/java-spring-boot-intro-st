package com.st.introduzione.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.introduzione.models.Autore;
import com.st.introduzione.models.AutoreDTO;
import com.st.introduzione.repositories.AutoreRepository;

@Service
public class AutoreService implements IServiceLettura<Autore>, IServiceScrittura<Autore> {

	@Autowired
	private AutoreRepository autRepo;

	@Override
	public List<Autore> cercaTutti() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Autore cercaPerId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Autore inserisci(Autore t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean elimina(Integer Id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifica(Autore t) {
		// TODO Auto-generated method stub
		return false;
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
	
	
}
