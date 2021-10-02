package com.raos.ecommerce.web.dao;

import com.raos.ecommerce.web.models.Cart;
import com.raos.ecommerce.web.models.User;

public class CartDAO extends DAO<Cart> {

	public CartDAO() {
		super(Cart.class);
	}
	
	public void addToCart(int productID, int cartID) {
		
	}
	
	public void deleteFromCart(int productID, int cartID) {
		
	}
	
	public void clearCart(User user) {
		
	}

}
