package com.pinxixi.vo.page;

import java.util.List;
import com.pinxixi.vo.Evaluation;
import com.pinxixi.vo.Model;

public class Details {
	private int SID;
	private Model model;
	private int CID;
	private String SName;
	private String SeriesSummary;
	private float Price;
	private int Stock;
	private String Color;
	private String Specification;
	private List<String> ComPicture;
	private List<Evaluation> Evaluations;
	public Details() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Details(int sID, Model model, int cID, String sName, String seriesSummary, float price, int stock,
			String color, String specification, List<String> comPicture, List<Evaluation> evaluations) {
		super();
		SID = sID;
		this.model = model;
		CID = cID;
		SName = sName;
		SeriesSummary = seriesSummary;
		Price = price;
		Stock = stock;
		Color = color;
		Specification = specification;
		ComPicture = comPicture;
		Evaluations = evaluations;
	}
	public int getSID() {
		return SID;
	}
	public void setSID(int sID) {
		SID = sID;
	}
	public Model getModel() {
		return model;
	}
	public void setModel(Model model) {
		this.model = model;
	}
	public int getCID() {
		return CID;
	}
	public void setCID(int cID) {
		CID = cID;
	}
	public String getSName() {
		return SName;
	}
	public void setSName(String sName) {
		SName = sName;
	}
	public String getSeriesSummary() {
		return SeriesSummary;
	}
	public void setSeriesSummary(String seriesSummary) {
		SeriesSummary = seriesSummary;
	}
	public float getPrice() {
		return Price;
	}
	public void setPrice(float price) {
		Price = price;
	}
	public int getStock() {
		return Stock;
	}
	public void setStock(int stock) {
		Stock = stock;
	}
	public String getColor() {
		return Color;
	}
	public void setColor(String color) {
		Color = color;
	}
	public String getSpecification() {
		return Specification;
	}
	public void setSpecification(String specification) {
		Specification = specification;
	}
	public List<String> getComPicture() {
		return ComPicture;
	}
	public void setComPicture(List<String> comPicture) {
		ComPicture = comPicture;
	}
	public List<Evaluation> getEvaluations() {
		return Evaluations;
	}
	public void setEvaluations(List<Evaluation> evaluations) {
		Evaluations = evaluations;
	}
	@Override
	public String toString() {
		return "Details [SID=" + SID + ", model=" + model + ", CID=" + CID + ", SName=" + SName + ", SeriesSummary="
				+ SeriesSummary + ", Price=" + Price + ", Stock=" + Stock + ", Color=" + Color + ", Specification="
				+ Specification + ", ComPicture=" + ComPicture + ", Evaluations=" + Evaluations + "]";
	}
	
}
