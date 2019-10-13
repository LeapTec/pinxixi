package com.pinxixi.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pinxixi.dao.AdviertisementDao;
import com.pinxixi.vo.Adviertisement;

@WebServlet("/back/BackAD")
public class BackAD extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 向dao层拿到数据
		AdviertisementDao dao = new AdviertisementDao();
		List<Adviertisement> list = dao.SelectAdviertisementAll();
		// 转发页面到ad.jsp
		request.setAttribute("list", list);
		request.getRequestDispatcher("ad.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
