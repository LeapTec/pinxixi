package com.pinxixi.vo.page;

import com.pinxixi.vo.Model;

public class ModelAndSname {
	private Model model;
	private String SName;
	public ModelAndSname() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ModelAndSname(Model model, String sName) {
		super();
		this.model = model;
		SName = sName;
	}
	@Override
	public String toString() {
		return "ModelAndSname [model=" + model + ", SName=" + SName + "]";
	}
	public Model getModel() {
		return model;
	}
	public void setModel(Model model) {
		this.model = model;
	}
	public String getSName() {
		return SName;
	}
	public void setSName(String sName) {
		SName = sName;
	}
	
}
