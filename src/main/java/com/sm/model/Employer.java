package com.sm.model;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "employer")
public class Employer {

	@Id
	private String id;

	@TextIndexed
	@Indexed(direction = IndexDirection.ASCENDING)
	private String email;

	private String fullName;

	private String mobilePhone;

	@TextIndexed
	private String companyName;

	@TextIndexed
	private NationalityE nationality;

//	@DBRef(lazy = true)
	@DBRef
	private Address address;

	@Field
	private MonthlyPayroll monthlyPayroll;

	private Collection<PaymentTransactionHistory> paymentTransactionHistory = new ArrayList<>();

	@Transient
	private String extraData;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public NationalityE getNationality() {
		return nationality;
	}

	public void setNationality(NationalityE nationality) {
		this.nationality = nationality;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public MonthlyPayroll getMonthlyPayroll() {
		return monthlyPayroll;
	}

	public void setMonthlyPayroll(MonthlyPayroll monthlyPayroll) {
		this.monthlyPayroll = monthlyPayroll;
	}

	public Collection<PaymentTransactionHistory> getPaymentTransactionHistory() {
		return paymentTransactionHistory;
	}

	public void setPaymentTransactionHistory(Collection<PaymentTransactionHistory> paymentTransactionHistory) {
		this.paymentTransactionHistory = paymentTransactionHistory;
	}

	public String getExtraData() {
		return extraData;
	}

	public void setExtraData(String extraData) {
		this.extraData = extraData;
	}
}
