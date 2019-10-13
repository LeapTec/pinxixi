package com.pinxixi.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pinxixi.dao.CommodityDao;
import com.pinxixi.utils.Constants;
import com.pinxixi.vo.Commodity;

@WebServlet("/CommodityUpdate")
public class CommodityUpdate extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int CID = Integer.valueOf(request.getParameter("CID"));
		int MID = Integer.valueOf(request.getParameter("MID"));
		String Color = request.getParameter("Color");
		float Price = Float.valueOf(request.getParameter("Price"));
		int Stock = Integer.valueOf(request.getParameter("Stock"));
		
		Commodity como = new Commodity();
		como.setCID(CID);
		como.setMID(MID);
		como.setColor(Color);
		como.setPrice(Price);
		como.setStock(Stock);
		
		
		CommodityDao comm = new CommodityDao();
		
		response.setCharacterEncoding(Constants.encodingFormat);
		response.setContentType("text/html;charset="+Constants.encodingFormat);
		if(comm.UpdateCommodity(como)) {
			request.getSession().setAttribute("CID", CID);
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\"> alert(\"更新商品成功！\"); window.top.location.href=\"商品管理页\"; </script>");
		}else {
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\"> alert(\"更新商品失败！\"); window.top.location.href=\"商品管理页\"; </script>");
		}
	}

}
