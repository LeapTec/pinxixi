package com.pinxixi.servlet;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pinxixi.dao.EvaluationDao;
import com.pinxixi.utils.*;
import com.pinxixi.vo.Evaluation;

/**
 * Servlet implementation class EvaluationAdd
 */
@WebServlet("/EvaluationAdd")
public class EvaluationAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EvaluationAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer OID = Integer.valueOf(request.getParameter("OID"));
		String PublishDate = DateUtil.timeStamp2Date2(DateUtil.timeStamp2(),"");
		String EvaDetails = request.getParameter("EvaDetails");
		
		Evaluation eva = new Evaluation();
		eva.setOID(OID);
		eva.setPublishDate(PublishDate);
		eva.setEvaDetails(EvaDetails);
		
		EvaluationDao evad = new EvaluationDao();
		
		response.setCharacterEncoding(Constants.encodingFormat);
		response.setContentType("text/html;charset="+Constants.encodingFormat);
		if(evad.AddEvaluation(eva)) {
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\"> alert(\"评价成功！\"); window.top.location.href=\"MyOrders\"; </script>");
		}else {
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\"> alert(\"评价失败！\"); window.top.location.href=\"pj.jsp?OID="+OID+"\"; </script>");
		}
	}

}
