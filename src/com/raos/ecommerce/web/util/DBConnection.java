package com.raos.ecommerce.web.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public final class DBConnection {
	private static final SessionFactory factory;
	
	static {
		factory = new Configuration().configure().buildSessionFactory();
	}
	
	private DBConnection() {
		
	}
	
	public static Session newSession() {
		return factory.openSession();
	}

}
