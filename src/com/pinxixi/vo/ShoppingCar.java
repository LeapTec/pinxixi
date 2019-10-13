package com.pinxixi.vo;

public class ShoppingCar {
	private int UID;
	private int CID;
	private int Amount;

	public ShoppingCar() {
		super();
	}

	public ShoppingCar(int uID, int cID, int amount) {
		super();
		UID = uID;
		CID = cID;
		Amount = amount;
	}

	public int getUID() {
		return UID;
	}

	public void setUID(int uID) {
		UID = uID;
	}

	public int getCID() {
		return CID;
	}

	public void setCID(int cID) {
		CID = cID;
	}

	public int getAmount() {
		return Amount;
	}

	public void setAmount(int amount) {
		Amount = amount;
	}

	public String toString() {
		return "ShoppingCar [UID=" + UID + ", CID=" + CID + ", Amount=" + Amount + "]";
	}

}
