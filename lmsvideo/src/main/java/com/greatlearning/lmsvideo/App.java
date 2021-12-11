package com.greatlearning.lmsvideo;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main( String[] args ) {
		// create session factory object
		Configuration con = new Configuration().configure( "hibernate.cfg.xml" ).addAnnotatedClass( Book.class );
		SessionFactory sessionFactory = con.buildSessionFactory();
		
		// create BookServiceImpl object and pass it the session factory object
		BookService bs = new BookServiceImpl( sessionFactory );

		List<Book> books = bs.findAll();
		
		for( Book book : books ) {
			System.out.println( book );
		}
	}
}