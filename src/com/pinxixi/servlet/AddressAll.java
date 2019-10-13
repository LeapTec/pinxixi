package com.pinxixi.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pinxixi.dao.AddressDao;
import com.pinxixi.dao.UsersDao;
import com.pinxixi.vo.Address;

@WebServlet("/AddressAll")
public class AddressAll extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AddressDao addrDao = new AddressDao();
		UsersDao usersDao = new UsersDao();
		int UID = usersDao.SelectUNameUser((String) request.getSession().getAttribute("LoginName")).getUID();
		List<Address> list = addrDao.SelectAddressAll(UID);
		request.setAttribute("list", list);
		request.getRequestDispatcher("address.jsp").forward(request, response);
	}

}
