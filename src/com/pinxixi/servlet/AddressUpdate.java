package com.pinxixi.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pinxixi.dao.*;
import com.pinxixi.utils.Constants;
import com.pinxixi.vo.Address;
/**
 * Servlet implementation class AddressUpdate
 */
@WebServlet("/AddressUpdate")
public class AddressUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddressUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int AID = Integer.valueOf(request.getParameter("AID"));
		int UID = Integer.valueOf(request.getParameter("UID"));
		String AName = request.getParameter("AName");
		String Phone = request.getParameter("Phone");
		String Area = request.getParameter("Area");
		String Address = request.getParameter("Address");
		
		Address add = new Address();
		add.setAName(AName);
		add.setPhone(Phone);
		add.setArea(Area);
		add.setAddress(Address);
		
		AddressDao addressDao = new AddressDao();
		
		addressDao.UpdateAddress(add);
		response.setCharacterEncoding(Constants.encodingFormat);
		response.setContentType("text/html;charset="+Constants.encodingFormat);
		if(addressDao.UpdateAddress(add)) {
			request.getSession().setAttribute("AName", AName);
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\"> alert(\"更新成功！\"); window.top.location.href=\"地址页\"; </script>");
		}else {
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\"> alert(\"更新失败！\"); window.location.href=\"地址页\"; </script>");
		}
		
		
		
	}

}
