package com.pinxixi.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pinxixi.dao.OrdersDao;
import com.pinxixi.vo.Orders;

/**
 * Servlet implementation class OrderOne
 */
@WebServlet("/OrderOne")
public class OrderOne extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderOne() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String OID = request.getParameter("OID");
		String UID = request.getParameter("UID");
		String AID = request.getParameter("AID");
		String CID = request.getParameter("CID");
		String Quantity = request.getParameter("Quantity");
		String OrderTime = request.getParameter("OrderTime");
		String PayTime = request.getParameter("PayTime");
		String DeliveryTime = request.getParameter("DeliveryTime");
		String Status = request.getParameter("Status");
		float ExpressFee = Float.valueOf(request.getParameter("ExpressFee"));
		String trackNum = request.getParameter("TrackNum");
		
		Orders order = new Orders();
		OrdersDao ord = new OrdersDao();
		
		ord.SelectOrdersOne(OID);
		request.getRequestDispatcher("订单页").forward(request, response);
	}

}
