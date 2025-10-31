package com.st.Lez02_Maven;

import com.st.Lez02_Maven.models.Studente;
import com.st.Lez02_Maven.models.StudenteDAO;

public class App 
{
    public static void main( String[] args )
    {
    	Studente mar = new Studente("Marika", "Mariko", "A012");
    	if(StudenteDAO.getInstance().insert(mar))
    		System.out.println("TUTTO OK");
    	else
    		System.out.println("ERRORE");
    }
}
