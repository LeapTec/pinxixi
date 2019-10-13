package com.pinxixi.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pinxixi.dao.EvaluationDao;
import com.pinxixi.utils.Constants;
import com.pinxixi.vo.Evaluation;

/**
 * Servlet implementation class EvaluationUpdate
 */
@WebServlet("/EvaluationUpdate")
public class EvaluationUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EvaluationUpdate() {
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
		int EID = Integer.valueOf(request.getParameter("EID"));
		int OID = Integer.valueOf(request.getParameter("OID"));
		String PublishDate = request.getParameter("PublishDate");
		String EvaDetails = request.getParameter("EvaDetails");
		
		Evaluation eva = new Evaluation();
		eva.setEID(EID);
		eva.setOID(OID);
		eva.setPublishDate(PublishDate);
		eva.setEvaDetails(EvaDetails);
		
		EvaluationDao evad = new EvaluationDao();
		
		response.setCharacterEncoding(Constants.encodingFormat);
		response.setContentType("text/html;charset="+Constants.encodingFormat);
		if(evad.UpdateEvaluation(eva)) {
			request.getSession().setAttribute("EID", EID);
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\"> alert(\"更新评价成功！\"); window.top.location.href=\"评价页\"; </script>");
		}else {
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\"> alert(\"更新评价失败！\"); window.top.location.href=\"评价页\"; </script>");
		}
	}
	}


