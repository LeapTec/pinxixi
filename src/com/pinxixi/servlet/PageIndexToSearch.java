package com.pinxixi.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pinxixi.dao.PageDao;
import com.pinxixi.vo.page.Search;

@WebServlet("/PageIndexToSearch")
public class PageIndexToSearch extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String conditions = request.getParameter("conditions");
		PageDao pageDao = new PageDao();
		List<Search> list = pageDao.SearchPage(conditions, 0, 0, 1);
		request.setAttribute("conditions", conditions);
		request.setAttribute("SorType", 0);
		request.setAttribute("Sort", 1);
		request.setAttribute("BID", 0);
		request.setAttribute("Searchlist", list);
		request.getRequestDispatcher("/search.jsp").forward(request, response);
	}

}
