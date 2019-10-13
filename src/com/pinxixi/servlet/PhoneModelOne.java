package com.pinxixi.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pinxixi.dao.ModelDao;
import com.pinxixi.vo.Model;

/**
 * Servlet implementation class PhoneModelOne
 */
@WebServlet("/PhoneModelOne")
public class PhoneModelOne extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PhoneModelOne() {
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
		String SID = request.getParameter("SID");
		float Size = Float.valueOf(request.getParameter("Size"));
		String Resolution = request.getParameter("Resolution");
		String OS = request.getParameter("OS");
		int RAM = Integer.valueOf(request.getParameter("RAM"));
		int ROM = Integer.valueOf(request.getParameter("ROM"));
		String FrontCamera = request.getParameter("FrontCamera");
		String RearCamera = request.getParameter("RearCamera");
		int Battery = Integer.valueOf(request.getParameter("Battery"));
		String SOC = request.getParameter("SOC");
		float Thickness = Float.valueOf(request.getParameter("Thickness"));
		String SIMType = request.getParameter("SIMType");
		String Details = request.getParameter("Details");
		
		Model model = new Model();
		ModelDao modeldao = new ModelDao();
		
		modeldao.SelectModelOne(MID);
		request.getRequestDispatcher("PhoneModelAll").forward(request, response);
	}

}
