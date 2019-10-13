package com.pinxixi.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pinxixi.dao.CommodityDao;
import com.pinxixi.vo.Commodity;

@WebServlet("/back/BackCommodity")
public class BackCommodity extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 接收数据
		String conditions = request.getParameter("conditions");
		if (conditions == null) {
			conditions = "";
		}
		// 向dao层拿到数据
		CommodityDao dao = new CommodityDao();
		List<Commodity> list = dao.SelectCommodityAll(conditions);
		// 转发页面
		request.setAttribute("list", list);
		request.setAttribute("conditions", conditions);
		request.getRequestDispatcher("commodity.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
