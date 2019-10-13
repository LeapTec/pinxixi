package com.pinxixi.vo.page;

public class Search {
	private int SID;
	private String SName;
	private String Path;
	private float LowestPrice;
	private String Summary;
	public Search() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Search(int sID, String sName, String path, float lowestPrice, String summary) {
		super();
		SID = sID;
		SName = sName;
		Path = path;
		LowestPrice = lowestPrice;
		Summary = summary;
	}
	public int getSID() {
		return SID;
	}
	public void setSID(int sID) {
		SID = sID;
	}
	public String getSName() {
		return SName;
	}
	public void setSName(String sName) {
		SName = sName;
	}
	public String getPath() {
		return Path;
	}
	public void setPath(String path) {
		Path = path;
	}
	public float getLowestPrice() {
		return LowestPrice;
	}
	public void setLowestPrice(float lowestPrice) {
		LowestPrice = lowestPrice;
	}
	public String getSummary() {
		return Summary;
	}
	public void setSummary(String summary) {
		Summary = summary;
	}
	@Override
	public String toString() {
		return "Search [SID=" + SID + ", SName=" + SName + ", Path=" + Path + ", LowestPrice=" + LowestPrice
				+ ", Summary=" + Summary + "]";
	}
	
}
