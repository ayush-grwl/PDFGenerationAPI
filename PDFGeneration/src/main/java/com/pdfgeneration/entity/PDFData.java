package com.pdfgeneration.entity;

import java.util.List;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class PDFData {

	@NotNull(message = "Enter Seller Name")
	private String seller;
	
	@NotNull(message = "Enter Seller GST Number")
	@Size(min = 15, max = 15, message = "Enter Correct 15 Digit Seller GST Number")
	private String sellerGstin;
	
	@NotNull(message = "Enter Seller Address")
	private String sellerAddress;
	
	@NotNull(message = "Enter Buyer Name")
	private String buyer;
	
	@NotNull(message = "Enter Buyer GST Number")
	@Size(min = 15, max = 15, message = "Enter Correct 15 Digit Buyer GST Number")
	private String buyerGstin;
	
	@NotNull(message = "Enter Buyer Address")
	private String buyerAddress;
	
	@NotNull(message = "Enter Items")
	private List<Items> items;
	
	public PDFData(@NotNull(message = "Enter Seller Name") String seller,
			@NotNull(message = "Enter Seller GST Number") @Size(min = 15, max = 15, message = "Enter Correct 15 Digit Seller GST Number") String sellerGstin,
			@NotNull(message = "Enter Seller Address") String sellerAddress,
			@NotNull(message = "Enter Buyer Name") String buyer,
			@NotNull(message = "Enter Buyer GST Number") @Size(min = 15, max = 15, message = "Enter Correct 15 Digit Buyer GST Number") String buyerGstin,
			@NotNull(message = "Enter Buyer Address") String buyerAddress,
			@NotNull(message = "Enter Items") List<Items> items) {
		super();
		this.seller = seller;
		this.sellerGstin = sellerGstin;
		this.sellerAddress = sellerAddress;
		this.buyer = buyer;
		this.buyerGstin = buyerGstin;
		this.buyerAddress = buyerAddress;
		this.items = items;
	}
	
	public String getSeller() {
		return seller;
	}
	public void setSeller(String seller) {
		this.seller = seller;
	}
	public String getSellerGstin() {
		return sellerGstin;
	}
	public void setSellerGstin(String sellerGstin) {
		this.sellerGstin = sellerGstin;
	}
	public String getSellerAddress() {
		return sellerAddress;
	}
	public void setSellerAddress(String sellerAddress) {
		this.sellerAddress = sellerAddress;
	}
	public String getBuyer() {
		return buyer;
	}
	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}
	public String getBuyerGstin() {
		return buyerGstin;
	}
	public void setBuyerGstin(String buyerGstin) {
		this.buyerGstin = buyerGstin;
	}
	public String getBuyerAddress() {
		return buyerAddress;
	}
	public void setBuyerAddress(String buyerAddress) {
		this.buyerAddress = buyerAddress;
	}
	public List<Items> getItems() {
		return items;
	}
	public void setItems(List<Items> items) {
		this.items = items;
	}
	
}
