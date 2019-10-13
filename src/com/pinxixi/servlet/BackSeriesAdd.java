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

@WebServlet("/back/BackSeriesAdd")
public class BackSeriesAdd extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding(Constants.encodingFormat);
		response.setContentType("text/html;charset=" + Constants.encodingFormat);
		PrintWriter out = response.getWriter();
		// 接收数据
		Series s = new Series();
		s.setBID(Integer.valueOf(request.getParameter("BID")));
		s.setSName(request.getParameter("SName"));

		// dao
		SeriesDao dao = new SeriesDao();
		boolean flag = dao.AddSeries(s);
		// 反馈+跳转
		if(flag){
			out.print("<script>alert('添加成功!');window.top.location.href='BackSeries';</script>");
		}else{
			out.print("<script>alert('添加失败!');window.top.location.href='BackSeriesCheckBrand';</script>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
