package com.pinxixi.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pinxixi.dao.EvaluationDao;
import com.pinxixi.vo.Evaluation;

@WebServlet("/EvaluationDelete")
public class EvaluationDelete extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String EID = request.getParameter("EID");
		String OID = request.getParameter("OID");
		String PublishDate = request.getParameter("PublishDate");
		String EvaDetails = request.getParameter("EvaDetails");
		
		Evaluation eva = new Evaluation();
		EvaluationDao evad = new EvaluationDao();
		
		List<String> EIDList = (List<String>) request.getAttribute("EIDList");
		String msg;
		if(evad.DeletEvaluation(EIDList)) {
			msg = "删除成功！";
			request.setAttribute("EIDList", EIDList);
			request.getRequestDispatcher("评论页面").forward(request, response);
		}else {
			msg = "删除成功！";
			request.setAttribute("EIDList", EIDList);
			request.getRequestDispatcher("评论页面").forward(request, response);
		}
	}

}
