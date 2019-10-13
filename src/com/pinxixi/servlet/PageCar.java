package com.pinxixi.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pinxixi.dao.PageDao;
import com.pinxixi.vo.page.Car;

@WebServlet("/PageCar")
public class PageCar extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String UName = (String) request.getSession().getAttribute("LoginName");
		PageDao pageDao = new PageDao();
		List<Car> list = pageDao.CarPage(UName);
		request.setAttribute("carList", list);
		request.getRequestDispatcher("/car.jsp").forward(request, response);
	}

}
