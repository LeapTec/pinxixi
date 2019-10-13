package com.pinxixi.vo.page;

import com.pinxixi.vo.Address;
import com.pinxixi.vo.Commodity;
import com.pinxixi.vo.Model;
import com.pinxixi.vo.Orders;

public class UserOrders {
	private Orders orders;
	private Commodity commodity;
	private Model model;
	private String BName;
	private String SName;
	private Address address;
	private int evaluationStatus;
	public UserOrders() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserOrders(Orders orders, Commodity commodity, Model model,
			String bName, String sName, Address address, int evaluationStatus) {
		super();
		this.orders = orders;
		this.commodity = commodity;
		this.model = model;
		BName = bName;
		SName = sName;
		this.address = address;
		this.evaluationStatus = evaluationStatus;
	}
	public Orders getOrders() {
		return orders;
	}
	public void setOrders(Orders orders) {
		this.orders = orders;
	}
	public Commodity getCommodity() {
		return commodity;
	}
	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
	}
	public Model getModel() {
		return model;
	}
	public void setModel(Model model) {
		this.model = model;
	}
	public String getBName() {
		return BName;
	}
	public void setBName(String bName) {
		BName = bName;
	}
	public String getSName() {
		return SName;
	}
	public void setSName(String sName) {
		SName = sName;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public int getEvaluationStatus() {
		return evaluationStatus;
	}
	public void setEvaluationStatus(int evaluationStatus) {
		this.evaluationStatus = evaluationStatus;
	}
	@Override
	public String toString() {
		return "UserOrders [orders=" + orders + ", commodity=" + commodity
				+ ", model=" + model + ", BName=" + BName + ", SName=" + SName
				+ ", address=" + address + ", evaluationStatus="
				+ evaluationStatus + "]";
	}
	
}
