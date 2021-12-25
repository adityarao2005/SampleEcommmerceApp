package com.raos.ecommerce.web.dao;

import com.raos.ecommerce.web.models.Address;
import com.raos.ecommerce.web.models.User;

public class AddressDAO extends DAO<Address> {

	public AddressDAO() {
		super(Address.class);
	}

	public boolean addAddresses(Address address, User user) {
		if (!user.getAddresses().contains(address)) {
			user.getAddresses().add(address);
			session.save(address);
			session.update(user);
			return true;
		}
		return false;
	}
}
