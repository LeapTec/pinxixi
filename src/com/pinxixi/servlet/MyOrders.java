package com.pinxixi.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pinxixi.dao.UserOrdersDao;
import com.pinxixi.dao.UsersDao;
import com.pinxixi.vo.page.UserOrders;

/**
 * Servlet implementation class MyOrders
 */
@WebServlet("/MyOrders")
public class MyOrders extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String UName = (String) request.getSession().getAttribute("LoginName");
		
		UsersDao usersDao = new UsersDao();
		int UID = usersDao.SelectUNameUser(UName).getUID();
		UserOrdersDao userOrdersDao = new UserOrdersDao();
		List<UserOrders> list = userOrdersDao.UserOrders(UID);
		request.setAttribute("MyOrdersList", list);
		request.getRequestDispatcher("orders.jsp").forward(request, response);
	}

}
