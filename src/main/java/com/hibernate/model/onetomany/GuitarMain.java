package com.hibernate.model.onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.hibernate.util.HibernateUtil;

public class GuitarMain {

	public static void main(String[] args) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session =sf.openSession();
		session.beginTransaction();
		Guitar guitar = new Guitar();
		guitar.setGuitarName("Electric Guitar");
		GuitarStrings gs1=new GuitarStrings();
		gs1.setMaterial("Bronze");
		gs1.setGuitar(guitar);
		GuitarStrings gs2=new GuitarStrings();
		gs2.setMaterial("Bronze");
		gs2.setGuitar(guitar);
		guitar.getGuitarStrings().add(gs1);
		guitar.getGuitarStrings().add(gs2);
		/*Guitar guitar = session.get(Guitar.class, 1L);
		session.delete(guitar);*/
		session.saveOrUpdate(guitar);
		//System.out.println(guitar.getName());
		//System.out.println(guitar.getGuitarStrings().size());
		session.getTransaction().commit();
		session.close();
		sf.close();
	}

}
