package com.pinxixi.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.pinxixi.dao.CommodityDao;
import com.pinxixi.utils.Constants;
import com.pinxixi.utils.Upload;
import com.pinxixi.vo.Commodity;

@WebServlet("/back/BackCommodityAdd")
public class BackCommodityAdd extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding(Constants.encodingFormat);
		response.setContentType("text/html;charset=" + Constants.encodingFormat);
		PrintWriter out = response.getWriter();

		Commodity c = new Commodity();
		// 实例化Upload
		Upload upload = new Upload(getServletContext(), request, response, getServletConfig());
		SmartUpload su = new SmartUpload();
		boolean flag = true;
		try {
			// 执行upload方法
			su = upload.upload();
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		if (flag) {
			Integer filesNum = su.getFiles().getCount();
			if (filesNum > 0) {
				String[][] result = new String[filesNum][];
				try {
					result = upload.save(su);
				} catch (Exception e) {
					e.printStackTrace();
					flag = false;
				}
				if (flag && filesNum == result.length) {
					// 获取Upload的Request
					Request req = upload.getRequest();
					// 接收数据
					c.setColor(req.getParameter("Color"));
					c.setMID(Integer.valueOf(req.getParameter("MID")));
					c.setPrice(Float.valueOf(req.getParameter("Price")));
					c.setStock(Integer.valueOf(req.getParameter("Stock")));
					// 添加到数据库
					CommodityDao dao = new CommodityDao();
					flag = dao.AddCommodity(c, result);
					if (!flag) {
						upload.delete(result);
					}
				} else {
					// 删除刚上传的图片
					upload.delete(result);
					flag = false;
				}
			} else {
				flag = false;
			}
		}
		if (flag) {
			out.print("<script>alert('添加成功');window.top.location.href='BackCommodity';</script>");
		} else {
			out.print("<script>alert('添加失败');window.location.href='BackCommodityAddSel';</script>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
