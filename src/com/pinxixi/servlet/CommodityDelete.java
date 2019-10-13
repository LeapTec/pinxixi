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

@WebServlet("/CommodityDelete")
public class CommodityDelete extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String CID = request.getParameter("CID");
		String MID = request.getParameter("MID");
		String Color = request.getParameter("Color");
		String Price = request.getParameter("Price");
		String Stock = request.getParameter("Stock");
		
		Commodity como = new Commodity();
		CommodityDao comm = new CommodityDao();
		
		List<Integer> CIDList = (List<Integer>) request.getAttribute("CIDList"); 
		String msg;
		if(comm.DeletCommodity(CIDList)) {
			msg = "删除成功！";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("商品页").forward(request, response);
		}else {
			msg = "删除失败！";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("商品页").forward(request, response);
		}
		
	}

}
