package com.pinxixi.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pinxixi.dao.BrandDao;
import com.pinxixi.vo.Brand;

@WebServlet("/back/BackSales")
public class BackSales extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int BID = -1;
		if (request.getParameter("BID") != null) {
			BID = Integer.valueOf(request.getParameter("BID"));
		}
		String firstTime = request.getParameter("firstTime");
		String secondTime = request.getParameter("secondTime");
		BrandDao brandDao = new BrandDao();
		List<Brand> list = brandDao.SelectBrandAll("");
		request.setAttribute("brandList", list);
		request.setAttribute("BID", BID);
		request.setAttribute("firstTime", firstTime);
		request.setAttribute("secondTime", secondTime);
		request.getRequestDispatcher("/back/tj.jsp").forward(request, response);
	}

}
