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
import com.sun.swing.internal.plaf.metal.resources.metal_zh_TW;

/**
 * Servlet implementation class BackModeltoAdd
 */
@WebServlet("/back/BackModeltoAdd")
public class BackModeltoAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BackModeltoAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SeriesDao seriesDao = new SeriesDao();
		List<Series> list = seriesDao.SelectSeriesAll("");
		request.setAttribute("SeriesList", list);
		request.getRequestDispatcher("xhtj.jsp").forward(request, response);
	}

}
