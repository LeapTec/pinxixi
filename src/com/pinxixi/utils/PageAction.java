package com.pinxixi.utils;

import java.util.List;

import com.pinxixi.vo.Adviertisement;

public class PageAction {

	public static Adviertisement getAdviertisement(List<Adviertisement> list, String grade) {
		if (list != null && list.size() > 0) {
			for (Adviertisement ad : list) {
				if (grade.equals(ad.getGrade())) {
					return ad;
				}
			}
		}
		return new Adviertisement();
	}

}
