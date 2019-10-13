package com.pinxixi.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pinxixi.dao.*;
import com.pinxixi.vo.Model;
import com.pinxixi.vo.Series;
/**
 * Servlet implementation class BackModelToUpdate
 */
@WebServlet("/back/BackModelToUpdate")
public class BackModelToUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BackModelToUpdate() {
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
		String MID = request.getParameter("MID");
		String SName = request.getParameter("SName");
		ModelDao modelDao = new ModelDao();
		Model model = modelDao.SelectModelOne(MID);
		SeriesDao seriesDao = new SeriesDao();
		List<Series> list=seriesDao.SelectSeriesAll(SName);
		Series series=(Series)list.get(0);
		int SID = series.getSID();
		request.setAttribute("SID", SID);
		request.setAttribute("SName", SName);
		request.setAttribute("Model", model);
		list=seriesDao.SelectSeriesAll("");
		request.setAttribute("SeriesList", list);
		request.getRequestDispatcher("xhxg.jsp").forward(request, response);;
	}

}
