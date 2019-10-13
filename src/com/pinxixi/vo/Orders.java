package com.pinxixi.vo;

public class Orders {
	private int OID;
	private int UID;
	private int AID;
	private int CID;
	private int Quantity;
	private String OrderTime;
	private String PayTime;
	private String DeliveryTime;
	private String Status;
	private float ExpressFee;
	private String TrackNum;

	public Orders() {
		super();
	}

	public Orders(int oID, int uID, int aID, int cID, int quantity, String orderTime, String payTime,
			String deliveryTime, String status, float expressFee, String trackNum) {
		super();
		OID = oID;
		UID = uID;
		AID = aID;
		CID = cID;
		Quantity = quantity;
		OrderTime = orderTime;
		PayTime = payTime;
		DeliveryTime = deliveryTime;
		Status = status;
		ExpressFee = expressFee;
		TrackNum = trackNum;
	}

	public int getOID() {
		return OID;
	}

	public void setOID(int oID) {
		OID = oID;
	}

	public int getUID() {
		return UID;
	}

	public void setUID(int uID) {
		UID = uID;
	}

	public int getAID() {
		return AID;
	}

	public void setAID(int aID) {
		AID = aID;
	}

	public int getCID() {
		return CID;
	}

	public void setCID(int cID) {
		CID = cID;
	}

	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		Quantity = quantity;
	}

	public String getOrderTime() {
		return OrderTime;
	}

	public void setOrderTime(String orderTime) {
		OrderTime = orderTime;
	}

	public String getPayTime() {
		return PayTime;
	}

	public void setPayTime(String payTime) {
		PayTime = payTime;
	}

	public String getDeliveryTime() {
		return DeliveryTime;
	}

	public void setDeliveryTime(String deliveryTime) {
		DeliveryTime = deliveryTime;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public float getExpressFee() {
		return ExpressFee;
	}

	public void setExpressFee(float expressFee) {
		ExpressFee = expressFee;
	}

	public String getTrackNum() {
		return TrackNum;
	}

	public void setTrackNum(String trackNum) {
		TrackNum = trackNum;
	}

	public String toString() {
		return "Orders [OID=" + OID + ", UID=" + UID + ", AID=" + AID + ", CID=" + CID + ", Quantity=" + Quantity
				+ ", OrderTime=" + OrderTime + ", PayTime=" + PayTime + ", DeliveryTime=" + DeliveryTime + ", Status="
				+ Status + ", ExpressFee=" + ExpressFee + ", TrackNum=" + TrackNum + "]";
	}

}
