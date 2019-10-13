package com.pinxixi.vo;

public class Adviertisement {
	private int ADID;
	private String Grade;
	private String ADDetails;
	private String Path;

	public Adviertisement() {
		super();
	}

	public Adviertisement(int aDID, String grade, String aDDetails, String path) {
		super();
		ADID = aDID;
		Grade = grade;
		ADDetails = aDDetails;
		Path = path;
	}

	public int getADID() {
		return ADID;
	}

	public void setADID(int aDID) {
		ADID = aDID;
	}

	public String getGrade() {
		return Grade;
	}

	public void setGrade(String grade) {
		Grade = grade;
	}

	public String getADDetails() {
		return ADDetails;
	}

	public void setADDetails(String aDDetails) {
		ADDetails = aDDetails;
	}

	public String getPath() {
		return Path;
	}

	public void setPath(String path) {
		Path = path;
	}

	public String toString() {
		return "Adviertisement [ADID=" + ADID + ", Grade=" + Grade + ", ADDetails=" + ADDetails + ", Path=" + Path
				+ "]";
	}

}
