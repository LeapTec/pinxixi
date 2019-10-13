package com.pinxixi.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pinxixi.dao.ShoppingCarDao;
import com.pinxixi.utils.Constants;
import com.pinxixi.vo.ShoppingCar;

/**
 * Servlet implementation class ShoppingCarUpdate
 */
@WebServlet("/ShoppingCarUpdate")
public class ShoppingCarUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShoppingCarUpdate() {
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
		int UID = Integer.valueOf(request.getParameter("UID"));
		int CID = Integer.valueOf(request.getParameter("CID"));
		int Amount = Integer.valueOf(request.getParameter("Amount"));
		
		ShoppingCar spc = new ShoppingCar();
		spc.setUID(UID);
		spc.setCID(CID);
		spc.setAmount(Amount);
		
		ShoppingCarDao spcd = new ShoppingCarDao();
		
		response.setCharacterEncoding(Constants.encodingFormat);
		response.setContentType("text/html;charset="+Constants.encodingFormat);
		if(spcd.UpdateShoppingCar(spc)) {
			request.getSession().setAttribute("UID", UID);
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\"> alert(\"更新购物车成功！\"); window.top.location.href=\"car.jsp\"; </script>");
		}else {
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\"> alert(\"更新购物车失败！\"); window.top.location.href=\"car.jsp\"; </script>");
		}
	}

}
