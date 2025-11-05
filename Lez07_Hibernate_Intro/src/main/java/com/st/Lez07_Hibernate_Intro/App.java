package com.st.Lez07_Hibernate_Intro;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.st.Lez07_Hibernate_Intro.models.Studente;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

    	SessionFactory sf = new Configuration()
    			.configure("/resources/hibernate.cfg.xml")
    			.addAnnotatedClass(Studente.class)
    			.buildSessionFactory();
    	
    	Session sessione = sf.getCurrentSession();
    	
    	//----------------------- INSERT
    	
//    	Studente uno = new Studente("Giovanni", "Pace", "A001");
//    	Studente due = new Studente("Mario", "Rossi", "A002");
//    	Studente tre = new Studente("Valeria", "Verdi", "A003");
//    
//    	try {
//    		sessione.beginTransaction();
//    		sessione.save(uno);
//    		sessione.save(due);
//    		sessione.save(tre);
//    		sessione.getTransaction().commit();
//    		
//    		System.out.println(uno);
//    		System.out.println(due);
//    		System.out.println(tre);
//    	} catch (Exception e) {
//			System.out.println(e.getMessage());
//		} finally {
//			sessione.close();
//			System.out.println("Sessione chiusa");
//		}

    	// -------------------------- CERCA
    	
    	try {
			
    		sessione.beginTransaction();
    		
//    		List<Studente> elenco = sessione.createQuery("FROM Studente").list();
//    		System.out.println(elenco);
    		
    		Studente stu = sessione.get(Studente.class, 2);
    		System.out.println(stu);
    		
    		sessione.getTransaction().commit();
    		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			sessione.close();
			System.out.println("Sessione chiusa");
		}
    	
    	
    }
}
