package com.pinxixi.vo;

public class Commodity {
	private int CID;
	private int MID;
	private String Color;
	private float Price;
	private int Stock;

	public Commodity() {
		super();
	}

	public Commodity(int cID, int mID, String color, float price, int stock) {
		super();
		CID = cID;
		MID = mID;
		Color = color;
		Price = price;
		Stock = stock;
	}

	public int getCID() {
		return CID;
	}

	public void setCID(int cID) {
		CID = cID;
	}

	public int getMID() {
		return MID;
	}

	public void setMID(int mID) {
		MID = mID;
	}

	public String getColor() {
		return Color;
	}

	public void setColor(String color) {
		Color = color;
	}

	public float getPrice() {
		return Price;
	}

	public void setPrice(float price) {
		Price = price;
	}

	public int getStock() {
		return Stock;
	}

	public void setStock(int stock) {
		Stock = stock;
	}

	public String toString() {
		return "Commodity [CID=" + CID + ", MID=" + MID + ", Color=" + Color + ", Price=" + Price + ", Stock=" + Stock
				+ "]";
	}

}
