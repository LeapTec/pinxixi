package com.pinxixi.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pinxixi.dao.BrandDao;
import com.pinxixi.utils.Constants;
import com.pinxixi.vo.Brand;

@WebServlet("/PhoneBrandUpdate")
public class PhoneBrandUpdate extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int BID = Integer.valueOf(request.getParameter("BID"));
		String BName = request.getParameter("BName");
		
		Brand brand = new Brand();
		brand.setBID(BID);
		brand.setBName(BName);
		
		BrandDao brandDao = new BrandDao();
		
		response.setCharacterEncoding(Constants.encodingFormat);
		response.setContentType("text/html;charset="+Constants.encodingFormat);
		if(brandDao.UpdateBrand(brand)) {
			request.getSession().setAttribute("BID", BID);
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\"> alert(\"更新品牌成功！\"); window.top.location.href=\"手机页\"; </script>");
		}else {
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\"> alert(\"更新品牌失败！\"); window.top.location.href=\"手机页\"; </script>");
		}
	}

}
