package com.pinxixi.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pinxixi.dao.SeriesDao;
import com.pinxixi.dao.ShoppingCarDao;
import com.pinxixi.dao.UsersDao;
import com.pinxixi.utils.Constants;
import com.pinxixi.vo.Series;
import com.pinxixi.vo.ShoppingCar;

@WebServlet("/ShoppingCarAdd")
public class ShoppingCarAdd extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding(Constants.encodingFormat);
		response.setContentType("text/html;charset=" + Constants.encodingFormat);
		PrintWriter out = response.getWriter();
		// 接收数据
		ShoppingCar s = new ShoppingCar();
		s.setAmount(Integer.valueOf(request.getParameter("number")));
		s.setCID(Integer.valueOf(request.getParameter("CID")));
		s.setUID(Integer.valueOf(new UsersDao().SelectUNameUser((String) request.getSession().getAttribute("LoginName")).getUID()));
		Integer SID = Integer.valueOf(request.getParameter("SID"));

		// dao
		ShoppingCarDao dao = new ShoppingCarDao();
		boolean flag = dao.AddShoppingCar(s);
		if(flag){
			out.print("<script>alert('添加成功!');window.top.location.href='PageDetails?id="+SID+"';</script>");
		}else{
			ShoppingCar sc = new ShoppingCar();
			sc = dao.SelectShoppingCarOne(s.getUID()+"", s.getCID()+"");
			sc.setAmount(sc.getAmount() + s.getAmount());
			flag = dao.UpdateShoppingCar(sc);
			out.print("<script>alert('添加"+(flag?"成功":"失败")+"!');window.top.location.href='PageDetails?id="+SID+"';</script>");
		}
	}

}
