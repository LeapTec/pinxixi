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
import com.pinxixi.dao.ModelDao;
import com.pinxixi.utils.Constants;

/**
 * Servlet implementation class BackModelDel
 */
@WebServlet("/back/BackModelDel")
public class BackModelDel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BackModelDel() {
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
		String MID[] = request.getParameterValues("MID");
		List<String> list = new ArrayList<String>();
		for(String s : MID){
			list.add(s);
		}
		// dao
		ModelDao modelDao = new ModelDao();
		boolean flag = modelDao.DeletModel(list);
		//反馈+跳转
		response.setCharacterEncoding(Constants.encodingFormat);
		response.setContentType("text/html;charset=" + Constants.encodingFormat);
		PrintWriter out = response.getWriter();
		out.print("<script>alert('删除" + (flag ? "成功" : "失败") + "!');window.top.location.href='BackModel';</script>");
	}

}
