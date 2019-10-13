package com.pinxixi.vo;

public class ComPicture {
	private int CPID;
	private int CID;
	private String Path;

	public ComPicture() {
		super();
	}

	public ComPicture(int cPID, int cID, String path) {
		super();
		CPID = cPID;
		CID = cID;
		Path = path;
	}

	public int getCPID() {
		return CPID;
	}

	public void setCPID(int cPID) {
		CPID = cPID;
	}

	public int getCID() {
		return CID;
	}

	public void setCID(int cID) {
		CID = cID;
	}

	public String getPath() {
		return Path;
	}

	public void setPath(String path) {
		Path = path;
	}

	public String toString() {
		return "ComPicture [CPID=" + CPID + ", CID=" + CID + ", Path=" + Path + "]";
	}

}
