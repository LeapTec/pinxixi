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

/**
 * Servlet implementation class PhoneSeriesDelete
 */
@WebServlet("/PhoneSeriesDelete")
public class PhoneSeriesDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PhoneSeriesDelete() {
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
		List<String> SIDList = (List<String>)request.getAttribute("SIDList");
		String msg;
		SeriesDao seriesDao=new SeriesDao();
		if(seriesDao.DeletSeries(SIDList)) {
			msg="删除成功";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("").forward(request, response);
		}else {
			msg="删除失败";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("").forward(request, response);
		}
	}

}
