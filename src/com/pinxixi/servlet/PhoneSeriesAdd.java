package com.pinxixi.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pinxixi.dao.SeriesDao;
import com.pinxixi.utils.Constants;
import com.pinxixi.vo.Series;

/**
 * Servlet implementation class PhoneSeriesAdd
 */
@WebServlet("/PhoneSeriesAdd")
public class PhoneSeriesAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PhoneSeriesAdd() {
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
		int SID = Integer.valueOf(request.getParameter("SID"));
		int BID = Integer.valueOf(request.getParameter("BID"));
		String SName = request.getParameter("SName");
		
		Series ser = new Series();
		ser.setSID(SID);
		ser.setBID(BID);
		ser.setSName(SName);
		
		SeriesDao serd = new SeriesDao();
		
		response.setCharacterEncoding(Constants.encodingFormat);
		response.setContentType("text/html;charset="+Constants.encodingFormat);
		if(serd.AddSeries(ser)) {
			request.getSession().setAttribute("BID", BID);
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\"> alert(\"添加系列成功！\"); window.top.location.href=\"手机页\"; </script>");
		}else {
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\"> alert(\"添加系列失败！\"); window.top.location.href=\"手机页\"; </script>");
		}
	}

	}


