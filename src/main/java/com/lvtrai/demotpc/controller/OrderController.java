package com.lvtrai.demotpc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lvtrai.demotpc.model.Order;
import com.lvtrai.demotpc.service.OrderService;


@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;
		
	@GetMapping("/all-order")
	public String daGiao(Model model) {
		Iterable<Order> orders = orderService.findAllOrder();
		model.addAttribute("orders", orders);
		return "allorder";
	}
}
