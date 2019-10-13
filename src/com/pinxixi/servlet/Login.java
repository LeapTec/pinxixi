package com.pinxixi.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pinxixi.dao.UserCheckDao;
import com.pinxixi.utils.Constants;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String UName=request.getParameter("UName");
		String UPassword=request.getParameter("UPassword");
		UserCheckDao userCheckDao=new UserCheckDao();
		response.setCharacterEncoding(Constants.encodingFormat);
		response.setContentType("text/html;charset="+Constants.encodingFormat);
		if(userCheckDao.UserCheck(UName, UPassword)) {
			request.getSession().setAttribute("LoginName", UName);
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\"> window.top.location.href=\"Index\"; </script>");
		}else {
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\"> alert(\"用户名或密码错误或该用户不存在\");window.location.href=\"login.jsp\"; </script>");
		}
	}

}
