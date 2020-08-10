package com.sm.model;

import java.math.BigDecimal;

public class CompanyPaymentHistoryDTO {
	private String id;
	private String name;
	private BigDecimal avgAmount;

	public CompanyPaymentHistoryDTO() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getAvgAmount() {
		return avgAmount;
	}

	public void setAvgAmount(BigDecimal avgAmount) {
		this.avgAmount = avgAmount;
	}

}
