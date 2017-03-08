package com.projectapi.teardowall.entity;

import java.io.Serializable;

public class DonateInfo extends BaseModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 677202933417654203L;
	private String donatorName;
	private String receiver;
	private double amount;
	
	public String getDonatorName() {
		return donatorName;
	}
	public void setDonatorName(String donatorName) {
		this.donatorName = donatorName;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
}
