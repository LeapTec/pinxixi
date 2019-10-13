package com.pinxixi.vo;

public class Series {
	private int SID;
	private int BID;
	private String SName;

	public Series() {
		super();
	}

	public Series(int sID, int bID, String sName) {
		super();
		SID = sID;
		BID = bID;
		SName = sName;
	}

	public int getSID() {
		return SID;
	}

	public void setSID(int sID) {
		SID = sID;
	}

	public int getBID() {
		return BID;
	}

	public void setBID(int bID) {
		BID = bID;
	}

	public String getSName() {
		return SName;
	}

	public void setSName(String sName) {
		SName = sName;
	}

	public String toString() {
		return "Series [SID=" + SID + ", BID=" + BID + ", SName=" + SName + "]";
	}

}
