package com.pinxixi.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.Request;
import com.pinxixi.dao.BrandDao;
import com.pinxixi.dao.ModelDao;
import com.pinxixi.utils.Constants;
import com.pinxixi.utils.Upload;
import com.pinxixi.vo.Brand;
import com.pinxixi.vo.Model;

@WebServlet("/back/BackModelUpdate")
public class BackModelUpdate extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding(Constants.encodingFormat);
		response.setContentType("text/html;charset=" + Constants.encodingFormat);
		PrintWriter out = response.getWriter();
		// 接收数据
		Model model = new Model();
		Upload upload = new Upload(getServletContext(), request, response, getServletConfig());
		try {
			upload.uploadAndSave();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 获取Upload的Request
		Request req = upload.getRequest();
		model.setMID(Integer.valueOf(req.getParameter("MID")));
		model.setSID(Integer.valueOf(req.getParameter("SID")));
		model.setSize(Float.valueOf(req.getParameter("Size")));
		model.setResolution(req.getParameter("Resolution"));
		model.setOS(req.getParameter("OS"));
		model.setRAM(Integer.valueOf(req.getParameter("RAM")));
		model.setROM(Integer.valueOf(req.getParameter("ROM")));
		model.setFrontCamera(req.getParameter("FrontCamera"));
		model.setRearCamera(req.getParameter("RearCamera"));
		model.setBattery(Integer.valueOf(req.getParameter("Battery")));
		model.setSOC(req.getParameter("SOC"));
		model.setThickness(Float.valueOf(req.getParameter("Thickness")));
		model.setSIMType(req.getParameter("SIMType"));
		model.setDetails(req.getParameter("Details"));

		// dao
		ModelDao modelDao = new ModelDao();
		boolean flag = modelDao.UpdateModel(model);
		// 反馈+跳转
		out.print("<script>alert('修改" + (flag ? "成功" : "失败") + "!');window.top.location.href='BackModel';</script>");
	}

}
