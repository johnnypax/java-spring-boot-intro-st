package com.st.Lez02_Maven.models.db;

import java.sql.Connection;
import java.sql.SQLException;

import com.mysql.cj.jdbc.MysqlDataSource;

public class ConnettoreDB {
	
	private static ConnettoreDB ogg_connettore;
	private Connection connessione;
	
	public static ConnettoreDB getIstanza() {
		if(ogg_connettore == null)
			ogg_connettore = new ConnettoreDB();
		
		return ogg_connettore;
	}
	
	private ConnettoreDB() {
		
	}
	
	public Connection getConnessione() throws SQLException {
		if(this.connessione == null) {
			MysqlDataSource dataSource = new MysqlDataSource();
	        dataSource.setServerName("127.0.0.1");
	        dataSource.setPort(3306);
	        dataSource.setUser("root");
	        dataSource.setPassword("toor");
	        dataSource.setDatabaseName("st_01_dipendenti");
	        dataSource.setUseSSL(false);
	        dataSource.setAllowPublicKeyRetrieval(true);
	        
	        this.connessione = dataSource.getConnection();
		}
		
        return this.connessione;
	}

}
