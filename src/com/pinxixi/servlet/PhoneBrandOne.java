package com.pinxixi.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pinxixi.dao.BrandDao;
import com.pinxixi.vo.Brand;

/**
 * Servlet implementation class PhoneBrandOne
 */
@WebServlet("/PhoneBrandOne")
public class PhoneBrandOne extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PhoneBrandOne() {
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
		String BID = request.getParameter("BID");
		String BName = request.getParameter("BName");
		
		Brand br = new Brand();
		BrandDao bd = new BrandDao();
		//
		bd.SelectBrandOne(BID);
		request.getRequestDispatcher("手机页").forward(request, response);
		
	}

}
