package com.pinxixi.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pinxixi.dao.CommodityDao;
import com.pinxixi.dao.OrdersDao;
import com.pinxixi.dao.ShoppingCarDao;
import com.pinxixi.dao.UsersDao;
import com.pinxixi.utils.Constants;
import com.pinxixi.utils.DateUtil;
import com.pinxixi.vo.Commodity;
import com.pinxixi.vo.Orders;

@WebServlet("/OrderAdd")
public class OrderAdd extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding(Constants.encodingFormat);
		response.setContentType("text/html;charset=" + Constants.encodingFormat);
		PrintWriter out = response.getWriter();
		// 接收数据
		List<Orders> list = new ArrayList<Orders>();
		Integer UID = new UsersDao().SelectUNameUser((String) request.getSession().getAttribute("LoginName")).getUID();
		Integer AID = Integer.valueOf(request.getParameter("AID"));
		String[] CN = request.getParameterValues("CN");
		for(String cn : CN){
			Orders o = new Orders();
			o.setUID(UID);
			o.setAID(AID);
			o.setCID(Integer.valueOf(cn.split("-")[0]));
			o.setQuantity(Integer.valueOf(cn.split("-")[1]));
			String time = DateUtil.timeStamp2Date2(DateUtil.timeStamp2(),"");
			o.setOrderTime(time);
			o.setPayTime(time);
			o.setStatus("未发货");
			o.setExpressFee(10);
			o.setTrackNum("");
			list.add(o);
		}

		// dao
		Integer num = 0;
		for(Orders o : list){
			Integer kucun = new CommodityDao().SelectCommodityOne( o.getCID()+"").getStock();
			if(o.getQuantity() <= kucun){
				if(new OrdersDao().AddOrders(o)){
					num++;
					// 修改库存
					kucun -= o.getQuantity();
					Commodity comm = new CommodityDao().SelectCommodityOne(o.getCID()+"");
					comm.setStock(kucun);
					new CommodityDao().UpdateCommodity(comm);
					// 如果是购物车的,删除购物车
					if("car".equals(request.getParameter("where"))){
						String[] car = {o.getUID()+"",o.getCID()+""};
						List<String[]> carList = new ArrayList<String[]>();
						carList.add(car);
						new ShoppingCarDao().DeletShoppingCar(carList);
					}
				}
			}
		}
		// 反馈+跳转
		out.print("<script>alert('已成功下单"+num+"个商品!');window.top.location.href='PageIndexToSearch?conditions=';</script>");
	}
}
