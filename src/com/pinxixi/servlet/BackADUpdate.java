package com.pinxixi.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.Request;
import com.pinxixi.dao.AdviertisementDao;
import com.pinxixi.utils.Constants;
import com.pinxixi.utils.Upload;
import com.pinxixi.vo.Adviertisement;

@WebServlet("/back/BackADUpdate")
public class BackADUpdate extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding(Constants.encodingFormat);
		response.setContentType("text/html;charset=" + Constants.encodingFormat);
		PrintWriter out = response.getWriter();
		Adviertisement ad = new Adviertisement();
		boolean flag = true;

		// 实例化Upload
		Upload upload = new Upload(getServletContext(), request, response, getServletConfig());
		try {
			// 执行upload方法
			String[][] result = upload.uploadAndSave();
			// 获取Upload的Request
			Request req = upload.getRequest();
			// 接收数据>需要执行upload() + getRequest()才能接收
			ad.setADID(Integer.valueOf(req.getParameter("ADID")));
			ad.setADDetails(req.getParameter("ADDetails"));
			ad.setGrade(req.getParameter("Grade"));
			// 旧图片地址
			String path = req.getParameter("Path");
			if (result[0][1] != null) {
				// 有上传新文件
				ad.setPath(result[0][1]);
			} else {
				// 没有上传新文件
				ad.setPath(path);
			}

			// 向dao层发送修改请求
			AdviertisementDao dao = new AdviertisementDao();
			if (dao.UpdateAdviertisement(ad)) {
				// 成功,删除旧图片
				if (result[0][1] != null) {
					upload.delete(path);
				}
			} else {
				flag = false;
				upload.delete(result);
			}
		} catch (Exception e) {
			flag = false;
		}

		// 反馈+跳转
		out.print("<script>alert('修改" + (flag ? "成功" : "失败") + "!');window.top.location.href='BackAD';</script>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
