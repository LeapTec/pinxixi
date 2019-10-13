package com.pinxixi.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pinxixi.dao.SeriesDao;
import com.pinxixi.vo.Series;

/**
 * Servlet implementation class PhoneSeriesOne
 */
@WebServlet("/PhoneSeriesOne")
public class PhoneSeriesOne extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PhoneSeriesOne() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String SID = request.getParameter("SID");
		SeriesDao serd = new SeriesDao();
		Series series=serd.SelectSeriesOne(SID);
		request.setAttribute("Series", series);
		request.getRequestDispatcher("手机页面").forward(request, response);
	}

}
