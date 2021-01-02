package com.lvtrai.demotpc.service;

import java.util.List;

import com.lvtrai.demotpc.model.Order;
import com.lvtrai.demotpc.model.Payment;
import com.lvtrai.demotpc.model.Shipping;
import com.lvtrai.demotpc.model.ShoppingCart;
import com.lvtrai.demotpc.model.User;


public interface OrderService {

	Order createOrder(ShoppingCart shoppingCart, Shipping shippingAddress, Payment payment, User user);
	
	List<Order> findByUser(User user);
	
	Order findOrderWithDetails(Long id);
}
