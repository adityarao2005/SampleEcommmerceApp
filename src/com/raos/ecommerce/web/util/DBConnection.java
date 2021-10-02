package com.raos.ecommerce.web.util;

import org.hibernate.Session;

import com.raos.ecommerce.web.listener.AppListener;

public final class DBConnection {
	
	private DBConnection() {
		
	}
	
	public static Session newSession() {
		return AppListener.getAppListener().getSessionFactory().openSession();
	}

}
