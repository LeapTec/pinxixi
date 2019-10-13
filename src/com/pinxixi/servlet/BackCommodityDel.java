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

import com.pinxixi.dao.BrandDao;
import com.pinxixi.dao.CommodityDao;
import com.pinxixi.utils.Constants;

@WebServlet("/back/BackCommodityDel")
public class BackCommodityDel extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 接收数据
		String CID[] = request.getParameterValues("CID");
		List<Integer> list = new ArrayList<Integer>();
		for(String s : CID){
			list.add(Integer.valueOf(s));
		}
		// dao
		CommodityDao dao = new CommodityDao();
		boolean flag = dao.DeletCommodity(list);
		//反馈+跳转
		response.setCharacterEncoding(Constants.encodingFormat);
		response.setContentType("text/html;charset=" + Constants.encodingFormat);
		PrintWriter out = response.getWriter();
		out.print("<script>alert('删除" + (flag ? "成功" : "失败") + "!');window.top.location.href='BackCommodity';</script>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
