package com.raos.ecommerce.web.dao;

import org.hibernate.criterion.Restrictions;

import com.raos.ecommerce.web.models.User;

public class UserDAO extends DAO<User> {
	public UserDAO() {
		super(User.class);
	}

	@SuppressWarnings({ "deprecation" })
	public User getUserByEmail(String email) {
		return (User) session.createCriteria(User.class).add(Restrictions.eq("email", email)).uniqueResult();
	}

	@SuppressWarnings({ "deprecation" })
	public User getUserByToken(String uuid) {
		return (User) session.createCriteria(User.class).add(Restrictions.eq("token", uuid)).uniqueResult();
	}
}
