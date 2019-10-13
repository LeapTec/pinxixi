package com.pinxixi.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pinxixi.dao.SeriesDao;
import com.pinxixi.vo.Series;

@WebServlet("/PhoneSeriesAll")
public class PhoneSeriesAll extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SeriesDao serd = new SeriesDao();
		String Concondition = request.getParameter("Concondition");
		List<Series> list = serd.SelectSeriesAll(Concondition);
		request.setAttribute("list", list);
		request.getRequestDispatcher("手机页面").forward(request, response);;
	}

}
