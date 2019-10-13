package com.pinxixi.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pinxixi.dao.AddressDao;
import com.pinxixi.utils.Constants;
import com.pinxixi.vo.Address;

@WebServlet("/AddressEdit")
public class AddressEdit extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding(Constants.encodingFormat);
		response.setContentType("text/html;charset=" + Constants.encodingFormat);
		PrintWriter out = response.getWriter();
		// 接收数据
		Address a = new Address();
		a.setAddress(request.getParameter("Address"));
		a.setAID(Integer.valueOf(request.getParameter("AID")));
		a.setAName(request.getParameter("AName"));
		a.setArea(request.getParameter("Area"));
		a.setPhone(request.getParameter("Phone"));
		a.setUID(Integer.valueOf(request.getParameter("UID")));
		// dao
		AddressDao dao = new AddressDao();
		boolean flag = dao.UpdateAddress(a);
		// 反馈+跳转
		out.print("<script>alert('修改" + (flag ? "成功" : "失败") + "!');window.location.href='AddressAll';</script>");
	}

}
