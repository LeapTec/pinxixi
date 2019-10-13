package com.pinxixi.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pinxixi.dao.BrandDao;
import com.pinxixi.dao.UsersDao;

@WebServlet("/back/BackBrandOne")
public class BackBrandOne extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 接收数据
		String BID = request.getParameter("BID");
		// 向dao层拿到数据
		BrandDao dao = new BrandDao();
		// 转发页面
		request.setAttribute("b", dao.SelectBrandOne(BID));
		request.getRequestDispatcher("ppxg.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
