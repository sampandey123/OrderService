package com.shiva.os.api.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionResponse {
	
	private int orderId;
	private double price;
	private String paymentStatus;
	private String transactionId;
	private String responseMessage;
	
	public TransactionResponse(int orderId2, double price2, String paymentStatus2, String transactionId2, String responseMessage2) {
		this.orderId = orderId2;
		this.price = price2;
		this.paymentStatus = paymentStatus2;
		this.transactionId = transactionId2;
		this.responseMessage = responseMessage2;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public String getResponseMessage() {
		return responseMessage;
	}
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

}
