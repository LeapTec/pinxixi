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

@WebServlet("/MyOrdersCancelCancel")
public class MyOrdersCancelCancel extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding(Constants.encodingFormat);
		response.setContentType("text/html;charset=" + Constants.encodingFormat);
		PrintWriter out = response.getWriter();
		// 接收数据
		Orders o = new OrdersDao().SelectOrdersOne(request.getParameter("OID"));
		o.setStatus(o.getStatus().split("-")[0]);

		// dao
		OrdersDao dao = new OrdersDao();
		boolean flag = dao.UpdateOrders(o);
		// 反馈+跳转
		out.print("<script>alert('取消退货操作" + (flag ? "成功" : "失败") + "!');window.location.href='MyOrders';</script>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
