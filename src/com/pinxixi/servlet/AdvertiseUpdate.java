package com.pinxixi.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pinxixi.*;
import com.pinxixi.dao.AdviertisementDao;
import com.pinxixi.utils.Constants;
import com.pinxixi.vo.Adviertisement;

@WebServlet("/AdvertiseUpdate")
public class AdvertiseUpdate extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int ADID = Integer.valueOf(request.getParameter("ADID"));
		String ADDetails = request.getParameter("ADDetails");
		String Path = request.getParameter("Path");
		
		Adviertisement ad = new Adviertisement();
		ad.setADDetails(ADDetails);
		ad.setPath(Path);
		
		AdviertisementDao adao = new AdviertisementDao();
		
		response.setCharacterEncoding(Constants.encodingFormat);
		response.setContentType("text/html;charset="+Constants.encodingFormat);
		if(adao.UpdateAdviertisement(ad)) {
			request.getSession().setAttribute("ADDetails", ADDetails);
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\"> alert(\"更新广告成功！\"); window.top.location.href=\"广告页\"; </script>");
		}else {
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\"> alert(\"更新广告失败！\"); window.top.location.href=\"广告页\"; </script>");
		}
		
	}

}
