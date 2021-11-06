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
		Cart cart = Objects.requireNonNull(user).getCart();
		if (cart == null) {
			cart = new Cart();
			user.setCart(cart);
			session.update(user);
			session.save(cart);
		}
		cart = this.load(cart.getId());
		if (cart.getProducts().containsKey(product)) {
			cart.getProducts().replace(product, cart.getProducts().get(product) + 1);
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
