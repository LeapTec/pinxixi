package com.pinxixi.vo;

public class Users {
	private int UID;
	private String UName;
	private String UPassword;
	private String Sex;
	private String UNumber;
	private String UNType;

	public int getUID() {
		return UID;
	}

	public void setUID(int uID) {
		UID = uID;
	}

	public String getUName() {
		return UName;
	}

	public void setUName(String uName) {
		UName = uName;
	}

	public String getUPassword() {
		return UPassword;
	}

	public void setUPassword(String uPassword) {
		UPassword = uPassword;
	}

	public String getSex() {
		return Sex;
	}

	public void setSex(String sex) {
		Sex = sex;
	}

	public String getUNumber() {
		return UNumber;
	}

	public void setUNumber(String uNumber) {
		UNumber = uNumber;
	}

	public String getUNType() {
		return UNType;
	}

	public void setUNType(String uNType) {
		UNType = uNType;
	}

	public Users() {
		super();
	}

	public Users(int uID, String uName, String uPassword, String sex, String uNumber, String uNType) {
		super();
		UID = uID;
		UName = uName;
		UPassword = uPassword;
		Sex = sex;
		UNumber = uNumber;
		UNType = uNType;
	}

	public String toString() {
		return "Users [UID=" + UID + ", UName=" + UName + ", UPassword=" + UPassword + ", Sex=" + Sex + ", UNumber="
				+ UNumber + ", UNType=" + UNType + "]";
	}

}
