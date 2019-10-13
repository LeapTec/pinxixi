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

@WebServlet("/back/BackOrdersCancelCheck")
public class BackOrdersCancelCheck extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding(Constants.encodingFormat);
		response.setContentType("text/html;charset=" + Constants.encodingFormat);
		PrintWriter out = response.getWriter();

		// 接收数据
		Orders o = new OrdersDao().SelectOrdersOne(request.getParameter("OID"));
		Integer check = Integer.valueOf(request.getParameter("check"));
		o.setStatus(check == 0 ? o.getStatus().split("-")[0] : "已取消");

		// dao
		boolean flag = new OrdersDao().UpdateOrders(o, check);
		// 反馈+跳转
		out.print("<script>alert('审核" + (flag ? "成功" : "失败") + "!');window.top.location.href='BackOrders';</script>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
