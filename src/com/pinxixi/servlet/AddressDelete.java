package com.pinxixi.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pinxixi.dao.AddressDao;
import com.pinxixi.utils.Constants;

@WebServlet("/AddressDelete")
public class AddressDelete extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 接收数据
		String AID[] = request.getParameterValues("AID");
		List<String> list = new ArrayList<String>();
		for (String s : AID) {
			list.add(s);
		}
		// dao
		AddressDao dao = new AddressDao();
		boolean flag = dao.DeletAddress(list);
		// 反馈+跳转
		response.setCharacterEncoding(Constants.encodingFormat);
		response.setContentType("text/html;charset=" + Constants.encodingFormat);
		PrintWriter out = response.getWriter();
		out.print("<script>alert('删除" + (flag ? "成功" : "失败") + "!');window.location.href='AddressAll';</script>");
	}

}
