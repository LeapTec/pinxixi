package com.pinxixi.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pinxixi.dao.ComPictureDao;
import com.pinxixi.utils.Constants;
import com.pinxixi.vo.ComPicture;

/**
 * Servlet implementation class ComPictureUpdate
 */
@WebServlet("/ComPictureUpdate")
public class ComPictureUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComPictureUpdate() {
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
		int CPID = Integer.valueOf(request.getParameter("CPID"));
		int CID = Integer.valueOf(request.getParameter("CID"));
		String Path = request.getParameter("Path");
		
		ComPicture comp = new ComPicture();
		comp.setCPID(CPID);
		comp.setCID(CID);
		comp.setPath(Path);
		
		ComPictureDao compd = new ComPictureDao();
		
		response.setCharacterEncoding(Constants.encodingFormat);
		response.setContentType("text/html;charset="+Constants.encodingFormat);
		if(compd.UpdateComPicture(comp)) {
			request.getSession().setAttribute("CPID", CPID);
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\"> alert(\"更新图片成功！\"); window.top.location.href=\"商品图片页\"; </script>");
		}else {
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\"> alert(\"更新图片失败！\"); window.top.location.href=\"商品图片页\"; </script>");
		}
	}
	}


