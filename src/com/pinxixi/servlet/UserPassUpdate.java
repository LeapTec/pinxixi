package com.pinxixi.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pinxixi.dao.UserCheckDao;
import com.pinxixi.dao.UsersDao;
import com.pinxixi.vo.Users;

/**
 * Servlet implementation class UserPassUpdate
 */
@WebServlet("/UserPassUpdate")
public class UserPassUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserPassUpdate() {
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
		String UName = (String)request.getSession().getAttribute("LoginName");
		String passOld = request.getParameter("UPassword1");
		String passNew = request.getParameter("UPassword2");
		String passNewCheck = request.getParameter("UPassword3");
		UserCheckDao userCheckDao = new UserCheckDao();
		//查询旧密码是否填写正确
		boolean t=userCheckDao.UserCheck(UName, passOld);
		if(t) {
			if(passNew.equals(passNewCheck) ) {
				request.getSession().setAttribute("UPassword", passNew);
				UsersDao usersDao = new UsersDao();
				usersDao.UpdateUsersPassword(UName, passNew);
				PrintWriter out = response.getWriter();
				request.getSession().removeAttribute("LoginName");
				
				out.println("<script type=\"text/javascript\"> alert(\"密码修改成功！\"); window.top.location.href=\"Index\"; </script>");
			}else {
				PrintWriter out = response.getWriter();
				out.println("<script type=\"text/javascript\"> alert(\"密码修改失败！两次输入的新密码不相同！\"); window.location.href=\"uppass.jsp\"; </script>");
			}
		}else {
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\"> alert(\"密码修改失败！你的旧密码不正确！\"); window.location.href=\"uppass.jsp\"; </script>");
		}
	}

}
