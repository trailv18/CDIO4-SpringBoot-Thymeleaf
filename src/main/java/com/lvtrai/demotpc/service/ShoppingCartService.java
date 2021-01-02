package com.lvtrai.demotpc.service;

import com.lvtrai.demotpc.model.CartItem;
import com.lvtrai.demotpc.model.Product;
import com.lvtrai.demotpc.model.ShoppingCart;
import com.lvtrai.demotpc.model.User;

public interface ShoppingCartService {

	ShoppingCart getShoppingCart(User user);
	
	int getItemsNumber(User user);
	
	CartItem findCartItemById(Long cartItemId);
	
	CartItem addArticleToShoppingCart(Product product, User user, int qty, String size);
		
	void clearShoppingCart(User user);
	
	void updateCartItem(CartItem cartItem, Integer qty);

	void removeCartItem(CartItem cartItem);
	
}
