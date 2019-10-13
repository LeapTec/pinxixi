package com.pinxixi.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pinxixi.dao.UsersDao;
import com.pinxixi.vo.Users;

/**
 * Servlet implementation class UsersDelete
 */
@WebServlet("/UsersDelete")
public class UsersDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsersDelete() {
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
		String UID = request.getParameter("UID");
		String UName = request.getParameter("UName");
		String UPassword = request.getParameter("UPassword");
		String Sex = request.getParameter("Sex");
		String UNumber = request.getParameter("UNumber");
		String UNTtype = request.getParameter("UNTtype");
		
		Users user = new Users();
		UsersDao userdao = new UsersDao();
		
		List<String> UIDList = (List<String>) request.getAttribute("UIDList");
		String msg;
		if(userdao.DeletUsers(UIDList)) {
			msg = "删除成功！";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("登陆页").forward(request, response);
		}else {
			msg = "删除失败！";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("登陆页").forward(request, response);
		}
	}

}
