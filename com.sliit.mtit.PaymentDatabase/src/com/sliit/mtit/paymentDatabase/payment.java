package com.sliit.mtit.paymentDatabase;

public class payment {
	private String id;
	private String stockeID;
	private Double price;
	private int amount;
	private Double tot;
	
	public payment() {
		super();
	}
	public payment(String id, String stockeID, Double price, int amount, Double tot) {
		super();
		this.id = id;
		this.stockeID = stockeID;
		this.price = price;
		this.amount = amount;
		this.tot = tot;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStockeID() {
		return stockeID;
	}
	public void setStockeID(String stockeID) {
		this.stockeID = stockeID;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Double getTot() {
		return tot;
	}
	public void setTot(Double tot) {
		this.tot = tot;
	}
	@Override
	public String toString() {
		return "payment [id=" + id + ", stockeID=" + stockeID + ", price=" + price + ", amount=" + amount + ", tot="
				+ tot + "]";
	}
}
