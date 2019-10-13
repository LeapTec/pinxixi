package com.pinxixi.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pinxixi.dao.CommodityDao;
import com.pinxixi.vo.Commodity;

/**
 * Servlet implementation class CommodityOne
 */
@WebServlet("/CommodityOne")
public class CommodityOne extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommodityOne() {
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
		String CID = request.getParameter("CID");
		String MID = request.getParameter("MID");
		String Color = request.getParameter("Color");
		String Price = request.getParameter("Price");
		String Stock = request.getParameter("Stock");
		
		Commodity como = new Commodity();
		CommodityDao comm = new CommodityDao();
		comm.SelectCommodityOne(CID);
		request.getRequestDispatcher("商品页").forward(request, response);
		
		
	}

}
