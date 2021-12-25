package com.raos.ecommerce.web.dao;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;

import com.raos.ecommerce.web.util.DBConnection;

public class DAO<T> implements AutoCloseable {
	protected Session session;
	protected Transaction transaction;
	private Class<T> clazz;

	public DAO(Class<T> clazz) {
		this.clazz = clazz;
		session = DBConnection.newSession();
		transaction = session.beginTransaction();
	}
	
	public boolean save(T t) {
		session.save(t);
		return true;
	}

	public T load(Serializable id) {
		T t = session.get(clazz, id);
		return t;
	}

	public void remove(T t) {
		session.remove(t);
	}
	
	public void delete(Serializable t) {
		T obj = session.get(clazz, t);
		if (obj != null) {
			remove(obj);
		}
	}

	public void update(T t) {
		session.update(t);
	}
	
	public void commit() {
		transaction.commit();
	}
	
	@SuppressWarnings("deprecation")
	public long getNumberOfRows() {
		return ((Long) session.createCriteria(clazz).setProjection(Projections.rowCount()).uniqueResult());
	}

	public void close() {
		commit();
		session.close();
	}
}
