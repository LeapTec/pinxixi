package com.pinxixi.filters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pinxixi.utils.Constants;

public class BackLoginStatusFilters implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		String uri = req.getRequestURI();
		boolean flag = true;
		if (uri.indexOf("back/") > -1) {
			// 代表是在后台的页面或者是后台的请求
			if (req.getSession().getAttribute("backUser") != null) {
				// 后台已登录
				if (uri.indexOf("back/login.jsp") > -1 || uri.indexOf("back/BackLogin") > -1) {
					// 重复登录.进入index.jsp
					resp.sendRedirect("index.jsp");
					flag = false;
				}
			} else {
				// 后台未登录
				if (uri.indexOf("back/login.jsp") < 0 && uri.indexOf("back/BackLogin") < 0) {
					// 未登录进入页面
					resp.setCharacterEncoding(Constants.encodingFormat);
					resp.setContentType("text/html;charset=" + Constants.encodingFormat);
					resp.getWriter().print("<script>alert('请先登录!');window.top.location.href='login.jsp';</script>");
					flag = false;
				}
			}
		}
		if (flag) {
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
