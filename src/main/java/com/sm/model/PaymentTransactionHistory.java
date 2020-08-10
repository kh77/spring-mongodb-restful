package com.sm.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PaymentTransactionHistory {

	private BigDecimal paymentAmount;
	private LocalDate paymentDate;

	public PaymentTransactionHistory() {

	}

	public PaymentTransactionHistory(BigDecimal paymentAmount, LocalDate paymentDate) {
		this.paymentAmount = paymentAmount;
		this.paymentDate = paymentDate;
	}

	public BigDecimal getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(BigDecimal paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}

}
