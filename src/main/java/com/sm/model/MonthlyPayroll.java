package com.sm.model;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Embedded Document
 *
 */
public class MonthlyPayroll {
	
    private BigDecimal totalAmount;
    private LocalDate date;
    
    public MonthlyPayroll() {
	}
    
	public MonthlyPayroll(BigDecimal totalAmount, LocalDate date) {
		this.totalAmount = totalAmount;
		this.date = date;
	}
	public BigDecimal getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
    
    

}
