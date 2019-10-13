package com.pinxixi.vo;

public class Evaluation {
	private int EID;
	private int OID;
	private String PublishDate;
	private String EvaDetails;

	public Evaluation() {
		super();
	}

	public Evaluation(int eID, int oID, String publishDate, String evaDetails) {
		super();
		EID = eID;
		OID = oID;
		PublishDate = publishDate;
		EvaDetails = evaDetails;
	}

	public int getEID() {
		return EID;
	}

	public void setEID(int eID) {
		EID = eID;
	}

	public int getOID() {
		return OID;
	}

	public void setOID(int oID) {
		OID = oID;
	}

	public String getPublishDate() {
		return PublishDate;
	}

	public void setPublishDate(String publishDate) {
		PublishDate = publishDate;
	}

	public String getEvaDetails() {
		return EvaDetails;
	}

	public void setEvaDetails(String evaDetails) {
		EvaDetails = evaDetails;
	}

	public String toString() {
		return "Evaluation [EID=" + EID + ", OID=" + OID + ", PublishDate=" + PublishDate + ", EvaDetails=" + EvaDetails
				+ "]";
	}

}
