package com.pdfgeneration.entity;

import jakarta.validation.constraints.NotNull;

public class Items {

	@NotNull(message = "Enter Item Name")
	private String name;
	
	@NotNull(message = "Enter Item Quantity")
	private String quantity;
	
	@NotNull(message = "Enter Item Rate")
	private double rate;
	
	@NotNull(message = "Enter Item Amount")
	private double amount;
	
	public Items(@NotNull(message = "Enter Item Name") String name,
			@NotNull(message = "Enter Item Quantity") String quantity,
			@NotNull(message = "Enter Item Rate") double rate, @NotNull(message = "Enter Item Amount") double amount) {
		super();
		this.name = name;
		this.quantity = quantity;
		this.rate = rate;
		this.amount = amount;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
}
