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
import com.pinxixi.utils.DateUtil;
import com.pinxixi.vo.Orders;

@WebServlet("/back/BackOrdersUpdate")
public class BackOrdersUpdate extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding(Constants.encodingFormat);
		response.setContentType("text/html;charset=" + Constants.encodingFormat);
		PrintWriter out = response.getWriter();
		
		// 接收数据
		Orders o = new OrdersDao().SelectOrdersOne(request.getParameter("OID"));
		o.setTrackNum(request.getParameter("TrackNum"));
		o.setStatus("已发货");
		o.setDeliveryTime(DateUtil.timeStamp2Date2(DateUtil.timeStamp2(),""));

		// dao
		boolean flag = new OrdersDao().UpdateOrders(o);
		// 反馈+跳转
		if(flag){
			out.print("<script>alert('发货成功!');window.top.location.href='BackOrders';</script>");
		}else{
			out.print("<script>alert('发货失败!');window.location.href='fh.jsp?OID=" + o.getOID() + "';</script>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
