package com.hibernate.model.manytomany;

import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


import com.hibernate.util.HibernateUtil;

public class BookAuthorMain {

	public static void main(String[] args) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session =sf.openSession();
		session.beginTransaction();
		Book book=new Book();
		book.setBookName("Coelho Biography");
		book.setBookType("Non-Fictional");
		
		Author author=new Author();
		author.setfName("Peter");
		author.setlName("Coelho");
		author.setPhoneNumber("1234567890");
		author.setDob(LocalDate.of(1978, 2, 5));
		book.getA1().add(author);
		Author author1=new Author();
		author1.setfName("Daniel");
		author1.setlName("Sampere");
		author1.setPhoneNumber("2154541231");
		author1.setDob(LocalDate.of(1976, 9, 15));
		
		book.getA1().add(author1);
		//author.getBook().add(book);
		session.save(book);
		session.save(author);
		session.save(author1);
		
		
		/*Book book = session.load(Book.class, 2L);
		session.delete(book);*/
		/*Author author = session.load(Author.class, 4L);
		session.delete(author);*/
		
		/*Book book = session.load(Book.class, 2L);
		Author author = session.load(Author.class, 1L);
		book.getA1().add(author);
		session.update(book);*/

		session.getTransaction().commit();
		session.close();
		sf.close();
	}

}
