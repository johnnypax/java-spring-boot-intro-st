package com.st.Lez02_Maven.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.st.Lez02_Maven.models.db.ConnettoreDB;

public class StudenteDAO implements InterfaceDAO<Studente> {

	private static StudenteDAO ogg_dao;
	
	public static StudenteDAO getInstance() {
		if(ogg_dao == null)
			ogg_dao = new StudenteDAO();
		
		return ogg_dao;
	}
	
	private StudenteDAO() {
		
	}
	
	@Override
	public Studente findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Studente> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(Studente t) {
		try {
			Connection conn = ConnettoreDB.getIstanza().getConnessione();
	        System.out.println("Sono connesso");
	        
	        String query = "INSERT INTO Studenti (nome, cognome, matricola) VALUES (?, ?, ?)";
	        PreparedStatement ps = conn.prepareStatement(query);
	        
	        ps.setString(1, t.getNom());
	        ps.setString(2, t.getCog());
	        ps.setString(3, t.getMat());
	        
	        int rowsAff = ps.executeUpdate();
	        if(rowsAff > 0)
	        	return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
        
		return false;
	}

	@Override
	public boolean update(Studente t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Studente t) {
		// TODO Auto-generated method stub
		return false;
	}

}
