package com.pinxixi.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pinxixi.dao.AddressDao;
import com.pinxixi.dao.UsersDao;
import com.pinxixi.utils.Constants;
import com.pinxixi.vo.Address;

@WebServlet("/AddressAdd")
public class AddressAdd extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsersDao usersDao=new UsersDao();
		int UID=usersDao.SelectUNameUser((String)request.getSession().getAttribute("LoginName")).getUID();
		String AName = request.getParameter("AName");
		String Phone = request.getParameter("Phone");
		String Area = request.getParameter("Area");
		String Address = request.getParameter("Address");

		Address add = new Address();
		add.setUID(UID);
		add.setAName(AName);
		add.setPhone(Phone);
		add.setArea(Area);
		add.setAddress(Address);
		
		AddressDao addr = new AddressDao();
		
		response.setCharacterEncoding(Constants.encodingFormat);
		response.setContentType("text/html;charset=" + Constants.encodingFormat);
		if (addr.AddAddress(add)) {
			request.getSession().setAttribute("AName", AName);
			PrintWriter out = response.getWriter();
			out.println(
					"<script type=\"text/javascript\"> alert(\"添加成功！\"); window.location.href=\"AddressAll\"; </script>");
		} else {
			PrintWriter out = response.getWriter();
			out.println(
					"<script type=\"text/javascript\"> alert(\"添加失败！\"); window.location.href=\"AddressAll\"; </script>");
		}
	}

}
