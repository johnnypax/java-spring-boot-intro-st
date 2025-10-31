package com.st.Lez02_Maven;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.MysqlDataSource;
import com.st.Lez02_Maven.models.Studente;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	try {
	        MysqlDataSource dataSource = new MysqlDataSource();
	        dataSource.setServerName("127.0.0.1");
	        dataSource.setPort(3306);
	        dataSource.setUser("root");
	        dataSource.setPassword("toor");
	        dataSource.setDatabaseName("st_01_dipendenti");
	        dataSource.setUseSSL(false);
	        dataSource.setAllowPublicKeyRetrieval(true);
	        
	        
	        // --------------------------- INSERT: start -----------------------------
//	        Connection conn = dataSource.getConnection();
//	        System.out.println("Sono connesso");
//	        
//	        
//	        String query = "INSERT INTO Studenti (nome, cognome, matricola) VALUES (?, ?, ?)";
//	        PreparedStatement ps = conn.prepareStatement(query);
//	        
//	        String nome = "Giovanni";
//	        String cognome = "Pace";
//	        String matricola = "A011";
//	        
//	        ps.setString(1, nome);
//	        ps.setString(2, cognome);
//	        ps.setString(3, matricola);
//	        
//	        int rowsAff = ps.executeUpdate();
//	        if(rowsAff > 0)
//	        	System.out.println("STAPPOOOOOO");
//	        else
//	        	System.out.println("ERRORE");
//	        
//	        conn.close();
	        // --------------------------- INSERT: end -----------------------------
	        
	        Connection conn = dataSource.getConnection();
	        System.out.println("Sono connesso");
	        
	        String query = "SELECT studenteID, nome, cognome, matricola FROM Studenti;";
	        PreparedStatement ps = conn.prepareStatement(query);
	        
	        ResultSet risultato = ps.executeQuery();
	        
	        while(risultato.next()) {
	        	Studente stu = new Studente();
	        	stu.setId( risultato.getInt("studenteID") );
	        	stu.setNom( risultato.getString("nome") );
	        	stu.setCog( risultato.getString("cognome") );
	        	stu.setMat( risultato.getString("matricola") );
	        	System.out.println(stu);
	        }
	        
	        conn.close();

	        
	        
    	} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
    }
}
