package org.nikhil.application;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.nikhil.model.User;

public class UserApplication {

	public static void main(String[] args) {
		
		String name;
		
		User user = new User();
		user.setFirstName("Genelia");
		user.setLastName("DSouza");
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		
		session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from User");
		
		List<User> list = query.list();
		
		for(User user1:list){
			name = user1.getFirstName();
			System.out.println(name);
		}
		
		session.getTransaction().commit();
		
	}

}
