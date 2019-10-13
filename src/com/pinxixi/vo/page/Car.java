package com.pinxixi.vo.page;

import com.pinxixi.vo.Commodity;
import com.pinxixi.vo.ShoppingCar;

public class Car {
	private ShoppingCar shoppingCar;
	private String BName;
	private String SName;
	private String storage;
	private Commodity commodity;
	private  String SIMType;
	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Car(ShoppingCar shoppingCar, String bName, String sName, String storage, Commodity commodity,
			String sIMType) {
		super();
		this.shoppingCar = shoppingCar;
		BName = bName;
		SName = sName;
		this.storage = storage;
		this.commodity = commodity;
		SIMType = sIMType;
	}
	public ShoppingCar getShoppingCar() {
		return shoppingCar;
	}
	public void setShoppingCar(ShoppingCar shoppingCar) {
		this.shoppingCar = shoppingCar;
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
	public String getStorage() {
		return storage;
	}
	public void setStorage(String storage) {
		this.storage = storage;
	}
	public Commodity getCommodity() {
		return commodity;
	}
	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
	}
	public String getSIMType() {
		return SIMType;
	}
	public void setSIMType(String sIMType) {
		SIMType = sIMType;
	}
	@Override
	public String toString() {
		return "Car [shoppingCar=" + shoppingCar + ", BName=" + BName + ", SName=" + SName + ", storage=" + storage
				+ ", commodity=" + commodity + ", SIMType=" + SIMType + "]";
	}
	
	
}
