package com.pinxixi.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pinxixi.dao.AddressDao;
import com.pinxixi.vo.Address;

/**
 * Servlet implementation class AddressOne
 */
@WebServlet("/AddressOne")
public class AddressOne extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddressOne() {
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
		int AID = Integer.valueOf(request.getParameter("AID"));
		String UID = request.getParameter("UID");
		String AName = request.getParameter("AName");
		String Phone = request.getParameter("Phone");
		String Area = request.getParameter("Area");
		String Address = request.getParameter("Address");
		
		Address add = new Address();
		AddressDao addr = new AddressDao();
		//utf-8
		
		addr.SelectAddressOne(AID);
		request.getRequestDispatcher("AddressAll").forward(request, response);
	}

}
