package com.raos.ecommerce.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mysql.cj.jdbc.AbandonedConnectionCleanupThread;

//import org.hibernate.Session;
//
//import com.mysql.cj.jdbc.AbandonedConnectionCleanupThread;
//import com.raos.ecommerce.web.util.DBConnection;

/**
 * Application Lifecycle Listener implementation class AppListener
 *
 */
@WebListener
public class AppListener implements ServletContextListener {
	private static AppListener globalListener;
	private static SessionFactory factory;

	/**
	 * Default constructor.
	 */
	public AppListener() {
	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent sce) {
		factory.close();
		factory = null;
		AppListener.globalListener = null;
		System.out.println("stopped");
		AbandonedConnectionCleanupThread.checkedShutdown();
	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
//	@SuppressWarnings("unused")
	public void contextInitialized(ServletContextEvent sce) {
		factory = new Configuration().configure().buildSessionFactory();
//		Session session = DBConnection.newSession();
		AppListener.globalListener = this;
		System.out.println("started");
	}

	public SessionFactory getSessionFactory() {
		return factory;
	}

	public static AppListener getAppListener() {
		return globalListener;
	}
}
