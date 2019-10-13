package com.pinxixi.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pinxixi.utils.Constants;

@WebServlet("/back/BackLogin")
public class BackLogin extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding(Constants.encodingFormat);
		response.setContentType("text/html;charset=" + Constants.encodingFormat);

		String username = request.getParameter("UName");
		String password = request.getParameter("UPassword");

		PrintWriter out = response.getWriter();

		if ("admin".equals(username) && "123456".equals(password)) {
			request.getSession().setAttribute("backUser", username);
			out.print("<script>window.location.href='index.jsp';</script>");
		} else {
			out.print("<script>alert('登录失败! 账号或密码不正确');window.location.href='login.jsp';</script>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
