package com.pinxixi.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pinxixi.dao.UsersDao;
import com.pinxixi.utils.Constants;
import com.pinxixi.vo.Users;

/**
 * Servlet implementation class UsersUpdate
 */
@WebServlet("/UsersUpdate")
public class UsersUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsersUpdate() {
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
		
		String UName = request.getParameter("UName");
		String UPassword = request.getParameter("UPassword");
		String Sex = request.getParameter("Sex");
		String UNumber = request.getParameter("UNumber");
		String UNType = request.getParameter("UNType");
		String oldUName=(String)request.getSession().getAttribute("LoginName");
		Users user = new Users();
		user.setUName(UName);
		user.setUPassword(UPassword);
		user.setSex(Sex);
		user.setUNumber(UNumber);
		user.setUNType(UNType);
		
		UsersDao userdao = new UsersDao();
		int UID = userdao.SelectUNameUser(oldUName).getUID();
		user.setUID(UID);
		
		response.setCharacterEncoding(Constants.encodingFormat);
		response.setContentType("text/html;charset="+Constants.encodingFormat);
		if(userdao.UpdateUsers(user)) {
			request.getSession().setAttribute("LoginName", UName);
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\"> alert(\"更新成功！\"); window.top.location.href=\"Index\"; </script>");
		}else {
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\"> alert(\"更新失败！\"); window.location.href=\"UsersInfo\"; </script>");
		}
		
	}

}
