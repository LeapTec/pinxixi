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
 * Servlet implementation class UsersAll
 */
@WebServlet("/UsersAll")
public class UsersAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsersAll() {
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
		
		List<Users> list = userdao.SelectUsersAll("");
		request.setAttribute("list", list);
		request.getRequestDispatcher("用户").forward(request, response);
	}

}
