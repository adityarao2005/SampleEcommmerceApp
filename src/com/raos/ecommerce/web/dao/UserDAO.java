package com.raos.ecommerce.web.dao;

import java.util.UUID;

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
	public User getUserByToken(UUID uuid) {
		System.out.println(uuid);
		return (User) session.createCriteria(User.class).add(Restrictions.eq("token", uuid)).uniqueResult();
	}
}
