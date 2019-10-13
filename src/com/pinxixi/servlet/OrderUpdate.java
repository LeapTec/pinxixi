package com.pinxixi.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pinxixi.dao.OrdersDao;
import com.pinxixi.utils.Constants;
import com.pinxixi.vo.Orders;

@WebServlet("/OrderUpdate")
public class OrderUpdate extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int OID = Integer.valueOf(request.getParameter("OID"));
		int UID = Integer.valueOf(request.getParameter("UID"));
		int AID = Integer.valueOf(request.getParameter("AID"));
		int CID = Integer.valueOf(request.getParameter("CID"));
		int Quantity = Integer.valueOf(request.getParameter("Quantity"));
		String OrderTime = request.getParameter("OrderTime");
		String PayTime = request.getParameter("PayTime");
		String DeliveryTime = request.getParameter("DeliveryTime");
		String Status = request.getParameter("Status");
		float ExpressFee = Float.valueOf(request.getParameter("ExpressFee"));
		String trackNum = request.getParameter("TrackNum");
		
		Orders order = new Orders();
		order.setOID(OID);
		order.setUID(UID);
		order.setAID(AID);
		order.setCID(CID);
		order.setQuantity(Quantity);
		order.setOrderTime(OrderTime);
		order.setPayTime(PayTime);
		order.setDeliveryTime(DeliveryTime);
		order.setStatus(Status);
		order.setExpressFee(ExpressFee);
		order.setTrackNum(trackNum);
		
		OrdersDao ord = new OrdersDao();
		
		response.setCharacterEncoding(Constants.encodingFormat);
		response.setContentType("text/html;charset="+Constants.encodingFormat);
		if(ord.UpdateOrders(order)) {
			request.getSession().setAttribute("OID", OID);
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\"> alert(\"更新订单成功！\"); window.top.location.href=\"订单页\"; </script>");
		}else {
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\"> alert(\"更新订单失败！\"); window.top.location.href=\"订单页\"; </script>");
		}
	}

}
