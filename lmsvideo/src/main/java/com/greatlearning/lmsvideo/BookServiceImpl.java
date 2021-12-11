package com.greatlearning.lmsvideo;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class BookServiceImpl implements BookService {
	private SessionFactory sessionFactory;
	private Session session;
	
	public BookServiceImpl( SessionFactory sessionFactory ) {
		this.sessionFactory = sessionFactory;
		try {
			this.session = this.sessionFactory.getCurrentSession();
		} catch( HibernateException e ) {
			this.session = this.sessionFactory.openSession();
		}
	}

	@Transactional
	public List<Book> findAll() {
		//		Transaction tx = session.beginTransaction();
		
		List<Book> books = session.createQuery( "from Book", Book.class ).list();
		
		//		tx.commit();
		
		return books;
	}

	@Transactional
	public List<Book> searchBy(String name, String author) {
		//	Transaction tx = session.beginTransaction();
		
		String query = "";
		
		if( name.length() != 0 && author.length() != 0 ) {
			query = "from Book where name like '%" + name + "%' or author like '%" + author + "%'";
		} else if( name.length() != 0 ) {
			query = "from Book where name like '%" + name + "%'";
		} else if( author.length() != 0 ) {
			query = "from Book where author like '%" + author + "%'";
		} else {
			System.out.println( "Cannot search without name or author being given" );
		}
		
		List<Book> books = session.createQuery( query, Book.class ).list();
		
		//		tx.commit();
		
		return books;
	}

	@Transactional
	public Book findById(int id) {
		//	Transaction tx = session.beginTransaction();
		
		Book book = session.get( Book.class, id );
		
		//  tx.commit();
		
		return book;
	}

	@Transactional
	public void save(Book book) {
		//		Transaction tx = session.beginTransaction();
		
		session.saveOrUpdate( book );
		
		//		tx.commit();
	}

	@Transactional
	public void deleteById(int id) {
		Transaction tx = session.beginTransaction();
		
		Book book = session.get( Book.class, id );
		session.delete( book );
		
		tx.commit();
	}
}
