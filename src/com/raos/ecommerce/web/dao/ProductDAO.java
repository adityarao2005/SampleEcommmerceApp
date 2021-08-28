package com.raos.ecommerce.web.dao;

import java.util.List;

import com.raos.ecommerce.web.models.Product;

public class ProductDAO extends DAO<Product> {

	public ProductDAO() {
		super(Product.class);
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<Product> getProducts(int limit, int page) {
		return session.createCriteria(Product.class).setMaxResults(limit).setFirstResult((page - 1)*limit).list();
	}
}
