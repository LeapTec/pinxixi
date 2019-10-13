package com.pinxixi.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pinxixi.dao.UsersDao;

@WebServlet("/back/BackUserOne")
public class BackUserOne extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 接收数据
		String UID = request.getParameter("UID");
		// 向dao层拿到数据
		UsersDao dao = new UsersDao();
		// 转发页面
		request.setAttribute("u", dao.SelectUIDUser(UID));
		request.getRequestDispatcher("yhxg.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
