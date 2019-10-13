package com.pinxixi.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pinxixi.dao.ShoppingCarDao;
import com.pinxixi.vo.ShoppingCar;

/**
 * Servlet implementation class ShoppingCarOne
 */
@WebServlet("/ShoppingCarOne")
public class ShoppingCarOne extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShoppingCarOne() {
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
		String UID = request.getParameter("UID");
		String CID = request.getParameter("CID");
		int Amount = Integer.valueOf(request.getParameter("Amount"));
		
		ShoppingCar spc = new ShoppingCar();
		ShoppingCarDao spcd = new ShoppingCarDao();
		
		spcd.SelectShoppingCarOne(UID, CID);
		request.getRequestDispatcher("购物车页").forward(request, response);
	}

}
