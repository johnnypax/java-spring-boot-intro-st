package com.st.introduzione.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.st.introduzione.models.CartaDTO;
import com.st.introduzione.models.Persona;
import com.st.introduzione.models.PersonaDTO;
import com.st.introduzione.repositories.PersonaRepository;

@Service
public class PersonaService implements IService<PersonaDTO> {

	@Autowired
	private PersonaRepository perRepo;
	
	@Autowired
	@Lazy
	private CartaService carServ;
	
	@Override
	public List<PersonaDTO> cercaTutti() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PersonaDTO cercaPerId(Integer id) {
		Persona per = perRepo.findById(id).orElse(null);
		
		PersonaDTO dto = null;
		
		if(per != null) {
			dto = new PersonaDTO();
			dto.setNom( per.getNominativo() );
			dto.setEma( per.getEmail() );
		}
		
		return dto;
	}
	
	public PersonaDTO cercaPerIdDettagliato(Integer id) {
		Persona per = perRepo.findById(id).orElse(null);
		
		PersonaDTO dto = null;
		
		if(per != null) {
			dto = new PersonaDTO();
			dto.setNom( per.getNominativo() );
			dto.setEma( per.getEmail() );
			
			List<CartaDTO> l = carServ.cercaPerProprietario(id);
			dto.setElencoCarte(l);
		}
		
		return dto;
	}

	@Override
	public PersonaDTO inserisci(PersonaDTO t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean elimina(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifica(PersonaDTO t) {
		// TODO Auto-generated method stub
		return false;
	}

}
