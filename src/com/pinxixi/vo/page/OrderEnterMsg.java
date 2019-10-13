package com.pinxixi.vo.page;

public class OrderEnterMsg {
	private String CID;
	private String msg;
	private double danjia;
	private Integer number;
	private double yunfei;
	private double xiaoji;

	public String getCID() {
		return CID;
	}

	public void setCID(String cID) {
		CID = cID;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public double getDanjia() {
		return danjia;
	}

	public void setDanjia(double danjia) {
		this.danjia = danjia;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public double getYunfei() {
		return yunfei;
	}

	public void setYunfei(double yunfei) {
		this.yunfei = yunfei;
	}

	public double getXiaoji() {
		return xiaoji;
	}

	public void setXiaoji(double xiaoji) {
		this.xiaoji = xiaoji;
	}

	public OrderEnterMsg() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderEnterMsg(String cID, String msg, double danjia, Integer number, double yunfei, double xiaoji) {
		super();
		CID = cID;
		this.msg = msg;
		this.danjia = danjia;
		this.number = number;
		this.yunfei = yunfei;
		this.xiaoji = xiaoji;
	}

	@Override
	public String toString() {
		return "OrderEnterMsg [CID=" + CID + ", msg=" + msg + ", danjia=" + danjia + ", number=" + number + ", yunfei="
				+ yunfei + ", xiaoji=" + xiaoji + "]";
	}

}
