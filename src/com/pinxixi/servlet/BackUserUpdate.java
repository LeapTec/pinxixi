package com.pinxixi.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pinxixi.dao.UsersDao;
import com.pinxixi.utils.Constants;
import com.pinxixi.vo.Users;

@WebServlet("/back/BackUserUpdate")
public class BackUserUpdate extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding(Constants.encodingFormat);
		response.setContentType("text/html;charset=" + Constants.encodingFormat);
		PrintWriter out = response.getWriter();
		// 接收数据
		Users u = new Users();
		u.setUID(Integer.valueOf(request.getParameter("UID")));
		u.setSex(request.getParameter("Sex"));
		u.setUName(request.getParameter("UName"));
		u.setUNType(request.getParameter("UNType"));
		u.setUNumber(request.getParameter("UNumber"));

		// dao
		UsersDao dao = new UsersDao();
		boolean flag = dao.UpdateUsers(u);
		// 反馈+跳转
		out.print("<script>alert('修改" + (flag ? "成功" : "失败") + "!');window.location.href='BackUserOne?UID="
				+ u.getUID() + "';</script>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
