package com.pinxixi.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pinxixi.dao.BrandDao;
import com.pinxixi.dao.ModelDao;
import com.pinxixi.vo.Brand;
import com.pinxixi.vo.Model;
import com.pinxixi.vo.page.ModelAndSname;

/**
 * Servlet implementation class BackModel
 */
@WebServlet("/back/BackModel")
public class BackModel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BackModel() {
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
		String conditions = request.getParameter("conditions");
		if (conditions == null) {
			conditions = "";
		}
		// 向dao层拿到数据
		ModelDao modelDao = new ModelDao();
		List<ModelAndSname> list = modelDao.SelectModelSname(conditions);
		// 转发页面
		request.setAttribute("ModelList", list);
		request.setAttribute("conditions", conditions);
		request.getRequestDispatcher("model.jsp").forward(request, response);
	}

}
