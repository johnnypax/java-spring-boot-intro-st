package com.st.introduzione.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.st.introduzione.models.Carta;
import com.st.introduzione.models.CartaDTO;
import com.st.introduzione.models.PersonaDTO;
import com.st.introduzione.repositories.CartaRepository;

@Service
public class CartaService implements IService<CartaDTO>{

	@Autowired
	private CartaRepository carRepo;
	
	@Autowired
	@Lazy
	private PersonaService perServ;
	
	@Override
	public List<CartaDTO> cercaTutti() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CartaDTO cercaPerId(Integer id) {
		Carta car = carRepo.findById(id).orElse(null);
		
		CartaDTO dto = null;
		if(car != null) {
			dto = new CartaDTO();
			dto.setCod( car.getCodice() );
			dto.setNeg( car.getNegozio() );
		}
		return dto;
	}
	
	public CartaDTO cercaPerIdConProprietario(Integer id, boolean isDettagliato) {
		Carta car = carRepo.findById(id).orElse(null);
		
		CartaDTO dto = null;
		if(car != null) {
			dto = new CartaDTO();
			dto.setCod( car.getCodice() );
			dto.setNeg( car.getNegozio() );
			
			if(isDettagliato) {
				PersonaDTO prop = perServ.cercaPerId( car.getPersonaRIF() );
				dto.setPro(prop);
			}			
		}
		return dto;
	}

	@Override
	public CartaDTO inserisci(CartaDTO t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean elimina(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifica(CartaDTO t) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public List<CartaDTO> cercaPerProprietario(Integer idProp){
		List<Carta> elenco = carRepo.findByPersonaRIF(idProp);
		List<CartaDTO> elDto = new ArrayList<CartaDTO>();
		
		for(int i=0; i<elenco.size(); i++) {
			CartaDTO dto = new CartaDTO();
			dto.setCod( elenco.get(i).getCodice() );
			dto.setNeg( elenco.get(i).getNegozio() );
			elDto.add(dto);
		}
		
		return elDto;
	}

}
