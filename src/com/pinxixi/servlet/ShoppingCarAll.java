package com.pinxixi.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pinxixi.dao.ShoppingCarDao;
import com.pinxixi.vo.ShoppingCar;

/**
 * Servlet implementation class ShoppingCarAll
 */
@WebServlet("/ShoppingCarAll")
public class ShoppingCarAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShoppingCarAll() {
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
		
		List<ShoppingCar> list = spcd.SelectShoppingCarAll("Concondition");
		request.setAttribute("list", list);
		request.getRequestDispatcher("购物车页").forward(request, response);
	}

}
