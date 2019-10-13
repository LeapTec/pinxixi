package com.pinxixi.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pinxixi.dao.BrandDao;
import com.pinxixi.dao.SaleDao;

@WebServlet("/back/BackSelectSale")
public class BackSelectSale extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取时间区间
		String time = request.getParameter("time");
		// 分割时间区间
		String firstTime = null, secondTime = null;
		if (time != null && !"".equals(time)) {
			String[] aStrings = time.split("~");
			firstTime = aStrings[0];
			secondTime = aStrings[1];
		}
		String BID = request.getParameter("BID");
		BID = BID != null && !"".equals(BID) ? BID:"0";
		// 查询
		SaleDao saleDao = new SaleDao();
		double sum = saleDao.SelectSale(BID, firstTime, secondTime);
		// 返回
		request.setAttribute("sum", sum);
		request.setAttribute("BID", BID);
		request.setAttribute("time", time);
		request.setAttribute("list", new BrandDao().SelectBrandAll(""));
		request.getRequestDispatcher("tj.jsp").forward(request, response);
	}

}
