package com.st.introduzione.services;

import org.springframework.stereotype.Service;

@Service
public class UserService {

	public boolean validazioneUtente(String user, String pass) {
		return user.equals("giovanni") && pass.equals("1234");
	}
	
}
