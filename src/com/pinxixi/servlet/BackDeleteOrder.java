package com.pinxixi.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pinxixi.dao.OrdersDao;
import com.pinxixi.utils.Constants;
import com.pinxixi.vo.Orders;

/**
 * Servlet implementation class BackDeleteOrder
 */
@WebServlet("/back/BackDeleteOrder")
public class BackDeleteOrder extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String OID[] = request.getParameterValues("OID");
		List<String> list = new ArrayList<String>();
		for(String s : OID){
			list.add(s);
		}
		OrdersDao ord = new OrdersDao();
		boolean flag=ord.DeletOrders(list);
		response.setCharacterEncoding(Constants.encodingFormat);
		response.setContentType("text/html;charset=" + Constants.encodingFormat);
		PrintWriter out = response.getWriter();
		out.print("<script>alert('删除" + (flag ? "成功" : "失败") + "!');window.top.location.href='BackOrders';</script>");
		
	}
}
