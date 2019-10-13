package com.pinxixi.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pinxixi.dao.ModelDao;
import com.pinxixi.vo.Model;

/**
 * Servlet implementation class BackModelAllSelectTeam
 */
@WebServlet("/BackModelAllSelectTeam")
public class BackModelAllSelectTeam extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BackModelAllSelectTeam() {
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
		//这个是另一个查全部的控制器
		//用于修改使用
		String conditions = request.getParameter("conditions");
		if (conditions == null) {
			conditions = "";
		}
		// 向dao层拿到数据
		ModelDao modelDao = new ModelDao();
		List<Model> list = modelDao.SelectModelAll(conditions);
		// 转发页面
		request.setAttribute("ModelList", list);
		request.setAttribute("conditions", conditions);
		request.getRequestDispatcher("xhxg.jsp").forward(request, response);
	}

}
