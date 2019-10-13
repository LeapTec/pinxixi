package com.pinxixi.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pinxixi.dao.BrandDao;
import com.pinxixi.dao.SeriesDao;
import com.pinxixi.dao.UsersDao;

@WebServlet("/back/BackSeriesCheckBrand")
public class BackSeriesCheckBrand extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 向dao层拿到数据
		BrandDao brandDao = new BrandDao();
		// 转发页面
		request.setAttribute("b", brandDao.SelectBrandAll(""));
		request.getRequestDispatcher("xltj.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
