package com.shiva.os.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.shiva.os.api.common.Payment;
import com.shiva.os.api.common.TransactionRequest;
import com.shiva.os.api.common.TransactionResponse;
import com.shiva.os.api.entity.Order;
import com.shiva.os.api.repository.OrderRepository;

@Service
public class OrderService {
	
	
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private RestTemplate restTemplate;
	
	public TransactionResponse saveOrder(TransactionRequest transactionRequest) {
		Order order = transactionRequest.getOrder();
		Payment payment = transactionRequest.getPayment();
		payment.setOrderId(order.getOrderid());
		payment.setPrice(order.getPrice());
		
		String response = "";
		
		Payment paymentResponse = restTemplate.postForObject("http://PAYMENT-SERVICE/payment/doPayment", payment, Payment.class);
		
		response = paymentResponse.getPaymentStatus().equals("Success")?"Payment successfull":"Payment unsuccessful, order need to be replaced";
		
		orderRepository.save(order);
		
		return new TransactionResponse(paymentResponse.getOrderId(),paymentResponse.getPrice(),
				paymentResponse.getPaymentStatus(),paymentResponse.getTransactionId(),response);
	}

}
