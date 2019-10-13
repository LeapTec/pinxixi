package com.pinxixi.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pinxixi.dao.ComPictureDao;
import com.pinxixi.vo.ComPicture;

/**
 * Servlet implementation class ComPictureDelete
 */
@WebServlet("/ComPictureDelete")
public class ComPictureDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComPictureDelete() {
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
		String CPID = request.getParameter("CPID");
		String CID = request.getParameter("CID");
		String Path = request.getParameter("Path");
		
		ComPicture comp = new ComPicture();
		ComPictureDao compd = new ComPictureDao();
		
		List<String> CPIDList = (List<String>) request.getAttribute("CPIDList");
		String msg;
		
		if(compd.DeletComPicture(CPIDList)) {
			msg = "删除成功！";
			request.setAttribute("CPIDList", CPIDList);
			request.getRequestDispatcher("商品页面").forward(request, response);
		}else {
			msg = "删除成功！";
			request.setAttribute("CPIDList", CPIDList);
			request.getRequestDispatcher("商品页面").forward(request, response);
		}
	}

}
