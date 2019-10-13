package com.pinxixi.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pinxixi.dao.EvaluationDao;
import com.pinxixi.vo.Evaluation;

/**
 * Servlet implementation class EvaluationOne
 */
@WebServlet("/EvaluationOne")
public class EvaluationOne extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EvaluationOne() {
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
		String EID = request.getParameter("EID");
		String OID = request.getParameter("OID");
		String PublishDate = request.getParameter("PublishDate");
		String EvaDetails = request.getParameter("EvaDetails");
		
		Evaluation eva = new Evaluation();
		EvaluationDao evad = new EvaluationDao();
		
		evad.SelectEvaluationOne(EID);
		request.getRequestDispatcher("评论页").forward(request, response);
	}

}
