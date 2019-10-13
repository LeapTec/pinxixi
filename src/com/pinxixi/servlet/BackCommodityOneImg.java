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

@WebServlet("/back/BackCommodityOneImg")
public class BackCommodityOneImg extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String CID = request.getParameter("CID");
		// 向dao层拿到数据
		ComPictureDao dao = new ComPictureDao();
		List<ComPicture> list = dao.SelectComPictureForCID(CID);
		// 转发页面
		request.setAttribute("CID", CID);
		request.setAttribute("list", list);
		request.getRequestDispatcher("sptp.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
