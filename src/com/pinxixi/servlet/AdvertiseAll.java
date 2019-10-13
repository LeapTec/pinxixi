package com.pinxixi.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pinxixi.dao.AdviertisementDao;
import com.pinxixi.vo.Adviertisement;

/**
 * Servlet implementation class AdvertiseAll
 */
@WebServlet("/AdvertiseAll")
public class AdvertiseAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdvertiseAll() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int ADID = Integer.valueOf(request.getParameter("ADID"));
		String ADDetails = request.getParameter("ADDetails");
		String Path = request.getParameter("Path");
		
		Adviertisement ad = new Adviertisement();
		AdviertisementDao adao = new AdviertisementDao();
		//
		List<Adviertisement> list = (List<Adviertisement>) adao.SelectAdviertisementAll();
		request.setAttribute("list", list);
		request.getRequestDispatcher("").forward(request, response);
	}

}
