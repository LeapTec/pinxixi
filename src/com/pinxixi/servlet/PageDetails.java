package com.pinxixi.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pinxixi.dao.PageDao;
import com.pinxixi.vo.page.Details;

@WebServlet("/PageDetails")
public class PageDetails extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int SID = Integer.valueOf(request.getParameter("id"));
		PageDao pageDao= new PageDao();
		List<Details> list= pageDao.DetailsPage(SID);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/details.jsp").forward(request, response);
	}

}
