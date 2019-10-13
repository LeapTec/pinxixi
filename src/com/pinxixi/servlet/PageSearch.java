package com.pinxixi.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pinxixi.dao.PageDao;
import com.pinxixi.vo.page.Search;
import com.sun.java_cup.internal.runtime.Symbol;

/**
 * Servlet implementation class SearchPage
 */
@WebServlet("/PageSearch")
public class PageSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PageSearch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String conditions=request.getParameter("conditions");
		int BID;
		int SorType;
		int Sort;
		if(request.getParameter("BID").equals("")) {
			BID=0;
		}else {
			BID=Integer.valueOf(request.getParameter("BID"));
		}
		if(request.getParameter("SorType").equals("")) {
			SorType=0;
		}else {
			SorType=Integer.valueOf(request.getParameter("SorType"));
		}
		if(request.getParameter("Sort").equals("")) {
			Sort=0;
		}else {
			Sort=Integer.valueOf(request.getParameter("Sort"));
		}
		
		PageDao pageDao=new PageDao();
		List<Search> list=pageDao.SearchPage(conditions, BID, SorType, Sort);
		request.setAttribute("conditions", conditions);
		request.setAttribute("BID", BID);
		request.setAttribute("SorType", SorType);
		request.setAttribute("Sort", Sort);
		request.setAttribute("Searchlist", list);
		request.getRequestDispatcher("/search.jsp").forward(request, response);
	}
}
