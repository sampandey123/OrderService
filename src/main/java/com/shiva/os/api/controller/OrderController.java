package com.shiva.os.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shiva.os.api.common.Payment;
import com.shiva.os.api.common.TransactionRequest;
import com.shiva.os.api.common.TransactionResponse;
import com.shiva.os.api.entity.Order;
import com.shiva.os.api.service.OrderService;


@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping("/bookOrder")
	public TransactionResponse bookOrder(@RequestBody TransactionRequest transactionRequest) {
				
		return orderService.saveOrder(transactionRequest);
	}
	

}
