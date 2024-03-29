package com.pinxixi.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pinxixi.dao.UserOrdersDao;
import com.pinxixi.utils.Constants;
import com.pinxixi.vo.page.UserOrders;
import com.sun.org.apache.xml.internal.serializer.ElemDesc;

/**
 * Servlet implementation class BackSelectOrder
 */
@WebServlet("/back/BackSelectOrder")
public class BackSelectOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BackSelectOrder() {
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
		response.setCharacterEncoding(Constants.encodingFormat);
		response.setContentType("text/html;charset=" + Constants.encodingFormat);
		String conditions=request.getParameter("conditions");
		UserOrdersDao userOrdersDao= new UserOrdersDao();
		List<UserOrders> list=userOrdersDao.BackSelectUserOrders(conditions);
		request.setAttribute("ordersList", list);
		request.getRequestDispatcher("orders.jsp").forward(request, response);
	}

}
