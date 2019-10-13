package com.pinxixi.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pinxixi.dao.ShoppingCarDao;
import com.pinxixi.dao.UsersDao;
import com.pinxixi.vo.ShoppingCar;

/**
 * Servlet implementation class ShoppingCarDelete
 */
@WebServlet("/ShoppingCarDelete")
public class ShoppingCarDelete extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String str[]=request.getParameterValues("UCID");
		UsersDao usersDao=new UsersDao();
		String UName=(String)request.getSession().getAttribute("LoginName");
		String UID=String.valueOf(usersDao.SelectUNameUser(UName).getUID());
		List<String[]> UIDCIDList=new ArrayList<>();
		
		for(String a:str) {
			String[] ta=new String[2];
			ta[0]=UID;
			ta[1]=a.split(",")[1];
			UIDCIDList.add(ta);
		}
		ShoppingCarDao spcd = new ShoppingCarDao();
		String msg;
		if(spcd.DeletShoppingCar(UIDCIDList)) {
			request.getRequestDispatcher("PageCar").forward(request, response);
		}else {
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\"> alert(\"删除失败！\"); window.location.href=\"PageCar\"; </script>");
		}
	}

}
