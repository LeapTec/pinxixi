package com.pinxixi.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pinxixi.dao.CommodityDao;
import com.pinxixi.dao.ModelDao;
import com.pinxixi.vo.Commodity;
import com.pinxixi.vo.Model;

@WebServlet("/back/BackCommodityOneMsg")
public class BackCommodityOneMsg extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 接收数据
		String CID = request.getParameter("CID");
		// 向dao层拿到数据
		ModelDao dao = new ModelDao();
		List<Model> list = dao.SelectModelAll("");
		// 转发页面
		request.setAttribute("list", list);
		request.setAttribute("com", new CommodityDao().SelectCommodityOne(CID));
		request.getRequestDispatcher("spjc.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
