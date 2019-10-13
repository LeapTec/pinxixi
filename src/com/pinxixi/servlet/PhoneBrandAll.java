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

@WebServlet("/PhoneBrandAll")
public class PhoneBrandAll extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String BID = request.getParameter("BID");
		String BName = request.getParameter("BName");
		
		Brand br = new Brand();
		BrandDao bd = new BrandDao();
		List<Brand> list = bd.SelectBrandAll("");   //参数
		request.setAttribute("list", list);
		request.getRequestDispatcher("手机页面").forward(request, response);
	}

}
