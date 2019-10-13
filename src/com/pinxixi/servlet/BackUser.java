package com.pinxixi.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pinxixi.dao.UsersDao;
import com.pinxixi.vo.Users;

@WebServlet("/back/BackUser")
public class BackUser extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 接收数据
		String conditions = request.getParameter("conditions");
		if (conditions == null) {
			conditions = "";
		}
		// 向dao层拿到数据
		UsersDao dao = new UsersDao();
		List<Users> list = dao.SelectUsersAll(conditions);
		// 转发页面
		request.setAttribute("list", list);
		request.setAttribute("conditions", conditions);
		request.getRequestDispatcher("user.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
