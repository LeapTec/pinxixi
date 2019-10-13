package com.pinxixi.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pinxixi.dao.ComPictureDao;
import com.pinxixi.vo.ComPicture;

@WebServlet("/ComPictureAll")
public class ComPictureAll extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String CPID = request.getParameter("CPID");
		String CID = request.getParameter("CID");
		String Path = request.getParameter("Path");
		
		ComPicture comp = new ComPicture();
		ComPictureDao compd = new ComPictureDao();
		List<ComPicture> list = compd.SelectComPictureAll("");
		request.setAttribute("list", list);
		request.getRequestDispatcher("商品页面").forward(request, response);
	}

}
