package com.pinxixi.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pinxixi.dao.BrandDao;
import com.pinxixi.vo.Brand;


@WebServlet("/PhoneBrandDelete")
public class PhoneBrandDelete extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String BID = request.getParameter("BID");
		String BName = request.getParameter("BName");
		
		Brand br = new Brand();
		BrandDao bd = new BrandDao();
		
		List<String> BIDList = (List<String>) request.getAttribute("BIDList");
		String msg;
		if(bd.DeletBrand(BIDList)) {
			msg = "删除成功！";
			request.setAttribute("BIDList", BIDList);//品牌方法
			request.getRequestDispatcher("手机页面").forward(request, response);
		}else {
			msg = "删除失败！";
			request.setAttribute("BIDList", BIDList);//品牌方法
			request.getRequestDispatcher("手机页面").forward(request, response);
		}
	}

}
