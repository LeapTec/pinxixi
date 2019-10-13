package com.pinxixi.vo;

public class Brand {
	private int BID;
	private String BName;

	public Brand() {
		super();
	}

	public Brand(int bID, String bName) {
		super();
		BID = bID;
		BName = bName;
	}

	public int getBID() {
		return BID;
	}

	public void setBID(int bID) {
		BID = bID;
	}

	public String getBName() {
		return BName;
	}

	public void setBName(String bName) {
		BName = bName;
	}

	public String toString() {
		return "Brand [BID=" + BID + ", BName=" + BName + "]";
	}

}
