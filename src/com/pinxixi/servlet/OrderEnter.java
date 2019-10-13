package com.pinxixi.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pinxixi.dao.AddressDao;
import com.pinxixi.dao.CommodityDao;
import com.pinxixi.dao.PageDao;
import com.pinxixi.dao.UsersDao;
import com.pinxixi.utils.Constants;
import com.pinxixi.vo.Address;
import com.pinxixi.vo.page.OrderEnterMsg;

@WebServlet("/OrderEnter")
public class OrderEnter extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding(Constants.encodingFormat);
		response.setContentType("text/html;charset=" + Constants.encodingFormat);

		// 获取自己的全部地址
		AddressDao addrDao = new AddressDao();
		UsersDao usersDao = new UsersDao();
		int UID = usersDao.SelectUNameUser((String) request.getSession().getAttribute("LoginName")).getUID();
		List<Address> list = addrDao.SelectAddressAll(UID);

		// 根据CID获取List<String>
		List<OrderEnterMsg> OEM = new ArrayList<OrderEnterMsg>();
		String[] CNS = request.getParameterValues("CIDNUM");
		double heji = 0;
		for (String CN : CNS) {
			OrderEnterMsg oem = new OrderEnterMsg();
			oem.setCID(CN.split("-")[0]);
			oem.setDanjia(new CommodityDao().SelectCommodityOne(oem.getCID()).getPrice());
			oem.setMsg(new PageDao().CIDtoCName(oem.getCID()));
			oem.setNumber(Integer.valueOf(CN.split("-")[1]));
			oem.setYunfei(10);
			oem.setXiaoji(oem.getDanjia() * oem.getNumber() + oem.getYunfei());
			OEM.add(oem);
			heji += oem.getXiaoji();
		}

		request.setAttribute("OEM", OEM);
		request.setAttribute("heji", heji);
		request.setAttribute("list", list);
		request.getRequestDispatcher("addorders.jsp?where="+request.getParameter("where")).forward(request, response);
	}

}
