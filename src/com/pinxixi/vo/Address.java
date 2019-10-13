package com.pinxixi.vo;

public class Address {
	private int AID;
	private int UID;
	private String AName;
	private String Phone;
	private String Area;
	private String Address;

	public Address() {
		super();
	}

	public Address(int aID, int uID, String aName, String phone, String area, String address) {
		super();
		AID = aID;
		UID = uID;
		AName = aName;
		Phone = phone;
		Area = area;
		Address = address;
	}

	public int getAID() {
		return AID;
	}

	public void setAID(int aID) {
		AID = aID;
	}

	public int getUID() {
		return UID;
	}

	public void setUID(int uID) {
		UID = uID;
	}

	public String getAName() {
		return AName;
	}

	public void setAName(String aName) {
		AName = aName;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public String getArea() {
		return Area;
	}

	public void setArea(String area) {
		Area = area;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String toString() {
		return "Address [AID=" + AID + ", UID=" + UID + ", AName=" + AName + ", Phone=" + Phone + ", Area=" + Area
				+ ", Address=" + Address + "]";
	}

}
