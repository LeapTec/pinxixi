package com.pinxixi.vo;

public class EvaPicture {
	private int EPID;
	private int EID;
	private String Path;

	public EvaPicture() {
		super();
	}

	public EvaPicture(int ePID, int eID, String path) {
		super();
		EPID = ePID;
		EID = eID;
		Path = path;
	}

	public int getEPID() {
		return EPID;
	}

	public void setEPID(int ePID) {
		EPID = ePID;
	}

	public int getEID() {
		return EID;
	}

	public void setEID(int eID) {
		EID = eID;
	}

	public String getPath() {
		return Path;
	}

	public void setPath(String path) {
		Path = path;
	}

	public String toString() {
		return "EvaPicture [EPID=" + EPID + ", EID=" + EID + ", Path=" + Path + "]";
	}

}
