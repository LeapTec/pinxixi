package com.pinxixi.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pinxixi.dao.SeriesDao;
import com.pinxixi.utils.Constants;
import com.pinxixi.vo.Series;

@WebServlet("/back/BackSeriesUpdate")
public class BackSeriesUpdate extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding(Constants.encodingFormat);
		response.setContentType("text/html;charset=" + Constants.encodingFormat);
		PrintWriter out = response.getWriter();
		// 接收数据
		Series s = new Series();
		s.setSID(Integer.valueOf(request.getParameter("SID")));
		s.setBID(Integer.valueOf(request.getParameter("BID")));
		s.setSName(request.getParameter("SName"));

		// dao
		SeriesDao dao = new SeriesDao();
		boolean flag = dao.UpdateSeries(s);
		// 反馈+跳转
		out.print("<script>alert('修改" + (flag ? "成功" : "失败") + "!');window.location.href='BackSeriesOne?SID="
				+ s.getSID() + "';</script>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
