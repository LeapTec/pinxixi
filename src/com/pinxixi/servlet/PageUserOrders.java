package com.pinxixi.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pinxixi.dao.UserOrdersDao;
import com.pinxixi.vo.page.UserOrders;

/**
 * Servlet implementation class PageUserOrders
 */
@WebServlet("/PageUserOrders")
public class PageUserOrders extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PageUserOrders() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int UID = Integer.valueOf(request.getParameter("UID"));
		UserOrdersDao userOrdersDao = new UserOrdersDao();
		List<UserOrders> list = userOrdersDao.UserOrders(UID);
		request.setAttribute("UserOrdersList", list);
		request.getRequestDispatcher("/orders.jsp").forward(request, response);
	}

}
