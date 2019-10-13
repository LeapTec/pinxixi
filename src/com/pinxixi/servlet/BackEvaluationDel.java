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

import com.pinxixi.dao.EvaluationDao;
import com.pinxixi.dao.UsersDao;
import com.pinxixi.utils.Constants;

@WebServlet("/back/BackEvaluationDel")
public class BackEvaluationDel extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 接收数据
		String EID[] = request.getParameterValues("EID");
		List<String> list = new ArrayList<String>();
		for (String s : EID) {
			list.add(s);
		}
		// dao
		EvaluationDao dao = new EvaluationDao();
		boolean flag = dao.DeletEvaluation(list);
		// 反馈+跳转
		response.setCharacterEncoding(Constants.encodingFormat);
		response.setContentType("text/html;charset=" + Constants.encodingFormat);
		PrintWriter out = response.getWriter();
		out.print("<script>alert('删除" + (flag ? "成功" : "失败") + "!');window.top.location.href='BackEvaluation';</script>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
