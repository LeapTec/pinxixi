package com.pinxixi.vo;

public class Model {
	private int MID;
	private int SID;
	private float Size;
	private String Resolution;
	private String OS;
	private int RAM;
	private int ROM;
	private String FrontCamera;
	private String RearCamera;
	private int Battery;
	private String SOC;
	private float Thickness;
	private String SIMType;
	private String Details;

	public Model() {
		super();
	}

	public Model(int mID, int sID, float size, String resolution, String oS, int rAM, int rOM,
			String frontCamera, String rearCamera, int battery, String sOC, float thickness, String sIMType,
			String details) {
		super();
		MID = mID;
		SID = sID;
		Size = size;
		Resolution = resolution;
		OS = oS;
		RAM = rAM;
		ROM = rOM;
		FrontCamera = frontCamera;
		RearCamera = rearCamera;
		Battery = battery;
		SOC = sOC;
		Thickness = thickness;
		SIMType = sIMType;
		Details = details;
	}

	public int getMID() {
		return MID;
	}

	public void setMID(int mID) {
		MID = mID;
	}

	public int getSID() {
		return SID;
	}

	public void setSID(int sID) {
		SID = sID;
	}

	public float getSize() {
		return Size;
	}

	public void setSize(float size) {
		Size = size;
	}

	public String getResolution() {
		return Resolution;
	}

	public void setResolution(String resolution) {
		Resolution = resolution;
	}

	public String getOS() {
		return OS;
	}

	public void setOS(String oS) {
		OS = oS;
	}

	public int getRAM() {
		return RAM;
	}

	public void setRAM(int rAM) {
		RAM = rAM;
	}

	public int getROM() {
		return ROM;
	}

	public void setROM(int rOM) {
		ROM = rOM;
	}

	public String getFrontCamera() {
		return FrontCamera;
	}

	public void setFrontCamera(String frontCamera) {
		FrontCamera = frontCamera;
	}

	public String getRearCamera() {
		return RearCamera;
	}

	public void setRearCamera(String rearCamera) {
		RearCamera = rearCamera;
	}

	public int getBattery() {
		return Battery;
	}

	public void setBattery(int battery) {
		Battery = battery;
	}

	public String getSOC() {
		return SOC;
	}

	public void setSOC(String sOC) {
		SOC = sOC;
	}

	public float getThickness() {
		return Thickness;
	}

	public void setThickness(float thickness) {
		Thickness = thickness;
	}

	public String getSIMType() {
		return SIMType;
	}

	public void setSIMType(String sIMType) {
		SIMType = sIMType;
	}

	public String getDetails() {
		return Details;
	}

	public void setDetails(String details) {
		Details = details;
	}

	public String toString() {
		return "Model [MID=" + MID + ", SID=" + SID + ", Size=" + Size + ", Resolution=" + Resolution + ", OS=" + OS
				+ ", RAM=" + RAM + ", ROM=" + ROM + ", FrontCamera=" + FrontCamera + ", RearCamera=" + RearCamera
				+ ", Battery=" + Battery + ", SOC=" + SOC + ", Thickness=" + Thickness + ", SIMType=" + SIMType
				+ ", Details=" + Details + "]";
	}

}
