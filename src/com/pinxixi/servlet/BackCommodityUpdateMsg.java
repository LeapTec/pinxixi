package com.pinxixi.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pinxixi.dao.BrandDao;
import com.pinxixi.dao.CommodityDao;
import com.pinxixi.utils.Constants;
import com.pinxixi.vo.Brand;
import com.pinxixi.vo.Commodity;

@WebServlet("/back/BackCommodityUpdateMsg")
public class BackCommodityUpdateMsg extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding(Constants.encodingFormat);
		response.setContentType("text/html;charset=" + Constants.encodingFormat);
		PrintWriter out = response.getWriter();
		// 接收数据
		Commodity c = new Commodity();
		c.setCID(Integer.valueOf(request.getParameter("CID")));
		c.setColor(request.getParameter("Color"));
		c.setMID(Integer.valueOf(request.getParameter("MID")));
		c.setPrice(Float.valueOf(request.getParameter("Price")));
		c.setStock(Integer.valueOf(request.getParameter("Stock")));

		// dao
		CommodityDao dao = new CommodityDao();
		boolean flag = dao.UpdateCommodity(c);
		// 反馈+跳转
		out.print("<script>alert('修改" + (flag ? "成功" : "失败") + "!');window.location.href='BackCommodityOneMsg?CID="
				+ c.getCID() + "';</script>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
