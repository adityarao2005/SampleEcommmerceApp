package com.raos.ecommerce.web.dao;

import java.util.Objects;

import com.raos.ecommerce.web.models.Cart;
import com.raos.ecommerce.web.models.Product;
import com.raos.ecommerce.web.models.User;

public class CartDAO extends DAO<Cart> {

	public CartDAO() {
		super(Cart.class);
	}
	
	public void addToCart(Product product, User user) {
		Objects.requireNonNull(product);
		// Add the product to the cart if not existing already
		Cart cart = user.getCart();
		if (cart == null) {
			user.setCart(cart = new Cart());
			cart.getProducts().put(product, 1);
		} else if (cart.getProducts().get(product) != null) {
			cart.getProducts().put(product, cart.getProducts().get(product) + 1);
		} else {
			cart.getProducts().put(product, 1);
		}
		// TODO: Add product to cart by creating controller called by ajax request
		// TODO: Display cart page with product name, quantity, total amount, gross total
	}
	
	public void deleteFromCart(String productID, int cartID) {
		
	}
	
	public void clearCart(User user) {
		
	}

}
