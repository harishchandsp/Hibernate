package com.hibernate.model.onetoone;


import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hibernate.util.HibernateUtil;

public class PersonMain {

	public static void main(String[] args) {
		System.out.println("Hibernate one to one (Annotation)");
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session =sf.openSession();
		session.beginTransaction();
		/*Person person =new Person();
		person.setFirstName("Harish2");
		person.setLastName("Sripalle2");
		person.setDob(LocalDate.of(1990,12,23));
		
		Passport passport=new Passport();
		passport.setPassportNumber("ABCD567");
		passport.setValidDate(LocalDate.of(2022, 8, 10));
		person.setPassport(passport);
		passport.setPerson(person);
		session.save(person);
		session.getTransaction().commit();
		session.close();
		sf.close();*/
		
		Person p = session.get(Person.class, 3L);
		System.out.println(p.getFirstName());
		System.out.println(p.getPassport().getValidDate());
		session.getTransaction().commit();
		session.close();
		sf.close();
		
		System.out.println("Execution completed");
	}

}
