package com.pinxixi.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pinxixi.dao.BrandDao;
import com.pinxixi.utils.Constants;
import com.pinxixi.vo.Brand;

@WebServlet("/back/BackBrandAdd")
public class BackBrandAdd extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding(Constants.encodingFormat);
		response.setContentType("text/html;charset=" + Constants.encodingFormat);
		PrintWriter out = response.getWriter();
		// 接收数据
		Brand b = new Brand();
		b.setBName(request.getParameter("BName"));

		// dao
		BrandDao dao = new BrandDao();
		boolean flag = dao.AddBrand(b);
		// 反馈+跳转
		if(flag){
			out.print("<script>alert('添加成功!');window.top.location.href='BackBrand';</script>");
		}else{
			out.print("<script>alert('添加失败!');window.top.location.href='pptj.jsp';</script>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
