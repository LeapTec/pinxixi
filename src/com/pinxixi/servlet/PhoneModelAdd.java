package com.pinxixi.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pinxixi.dao.ModelDao;
import com.pinxixi.utils.Constants;
import com.pinxixi.vo.Model;

/**
 * Servlet implementation class PhoneModelAdd
 */
@WebServlet("/PhoneModelAdd")
public class PhoneModelAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PhoneModelAdd() {
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
		int MID = Integer.valueOf(request.getParameter("MID"));
		int SID = Integer.valueOf(request.getParameter("SID"));
		float Size = Float.valueOf(request.getParameter("Size"));
		String Resolution = request.getParameter("Resolution");
		String OS = request.getParameter("OS");
		int RAM = Integer.valueOf(request.getParameter("RAM"));
		int ROM = Integer.valueOf(request.getParameter("ROM"));
		String FrontCamera = request.getParameter("FrontCamera");
		String RearCamera = request.getParameter("RearCamera");
		int Battery = Integer.valueOf(request.getParameter("Battery"));
		String SOC = request.getParameter("SOC");
		float Thickness = Float.valueOf(request.getParameter("Thickness"));
		String SIMType = request.getParameter("SIMType");
		String Details = request.getParameter("Details");
		
		Model model = new Model();
		model.setMID(MID);
		model.setSID(SID);
		model.setSize(Size);
		model.setResolution(Resolution);
		model.setOS(OS);
		model.setRAM(RAM);
		model.setROM(ROM);
		model.setFrontCamera(FrontCamera);
		model.setRearCamera(RearCamera);
		model.setBattery(Battery);
		model.setSOC(SOC);
		model.setThickness(Thickness);
		model.setSIMType(SIMType);
		model.setDetails(Details);
		
		ModelDao modeldao = new ModelDao();
		
		response.setCharacterEncoding(Constants.encodingFormat);
		response.setContentType("text/html;charset="+Constants.encodingFormat);
		if(modeldao.AddModel(model)) {
			request.getSession().setAttribute("MID", MID);
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\"> alert(\"添加机型成功！\"); window.top.location.href=\"手机页\"; </script>");
		}else {
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\"> alert(\"添加机型失败！\"); window.top.location.href=\"手机页\"; </script>");
		}
	}
}
