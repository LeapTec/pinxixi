package com.pinxixi.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pinxixi.dao.OrdersDao;
import com.pinxixi.vo.Orders;

@WebServlet("/DeleteOrder")
public class OrderDelete extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	
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
		List<String> OIDList = (List<String>) request.getAttribute("OIDList");
		String msg;
		if(ord.DeletOrders(OIDList)) {
			msg = "删除成功！";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("订单页").forward(request, response);
		}else {
			msg = "删除失败！";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("订单页").forward(request, response);
		}
		
	}

}
