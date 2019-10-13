package com.pinxixi.filters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pinxixi.utils.Constants;

public class LoginStatusFilters implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 获取request,response
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		// 转码
		resp.setCharacterEncoding(Constants.encodingFormat);
		resp.setContentType("text/html;charset=" + Constants.encodingFormat);
		// 获取路径
		String uri = req.getRequestURI();
		boolean flag = true;
		// 是否登录
		if (req.getSession().getAttribute("LoginName") != null) {
			// 已登录
			if (getUriFlag(1, uri)) {
				// 重复登录/注册
				// 进行跳转
				resp.getWriter().print("<script>alert('请先退出登录');window.top.location.href='Index';</script>");
				flag = false;
			}
		} else {
			// 未登录
			if (getUriFlag(0, uri)) {
				// 进行拦截,跳转
				resp.getWriter().print("<script>alert('请先登录');window.top.location.href='Index';</script>");
				flag = false;
			}
		}
		if (flag) {
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

	public static boolean getUriFlag(Integer where, String uri) {
		List<String> list = new ArrayList<String>();
		boolean flag = false;
		if (where.equals(0)) {
			list.add("pinxixi/PageCar");
			list.add("pinxixi/ShoppingCarDelete");
			list.add("pinxixi/OrderEnter");
			list.add("pinxixi/OrderAdd");
			list.add("pinxixi/ShoppingCarAdd");
			list.add("pinxixi/UsersInfo");
			list.add("pinxixi/UsersUpdate");
			list.add("pinxixi/uppass.jsp");
			list.add("pinxixi/UserPassUpdate");
			list.add("pinxixi/AddressAll");
			list.add("pinxixi/AddressAdd");
			list.add("pinxixi/AddressEdit");
			list.add("pinxixi/AddressDelete");
			list.add("pinxixi/MyOrders");
			list.add("pinxixi/LogOut");
			list.add("pinxixi/pj.jsp");
			list.add("pinxixi/EvaluationAdd");
			list.add("pinxixi/MyOrdersEnter");
		} else {
			list.add("pinxixi/login.jsp");
			list.add("pinxixi/register.jsp");
			list.add("pinxixi/Login");
			list.add("pinxixi/UsersRegister");
		}
		for (String s : list) {
			if (uri.indexOf(s) > -1) {
				flag = true;
				break;
			}
		}
		return flag;
	}
}
