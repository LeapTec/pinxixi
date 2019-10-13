package com.pinxixi.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pinxixi.dao.UsersDao;
import com.pinxixi.vo.Users;

@WebServlet("/UsersInfo")
public class UsersInfo extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UsersDao usersDao = new UsersDao();
		String UName = (String) request.getSession().getAttribute("LoginName");
		Users users = usersDao.SelectUNameUser(UName);
		request.setAttribute("User", users);
		request.getRequestDispatcher("msg.jsp").forward(request, response);

		PrintWriter out = response.getWriter();
		out.println("<script type=\"text/javascript\"> window.location.href=\"msg.jsp\"; </script>");

	}

}
