package com.pinxixi.utils;

import java.io.File;
import java.util.UUID;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;

public class Upload {
	private ServletContext servletContext;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private ServletConfig servletConfig;
	private SmartUpload su;

	public Upload(ServletContext servletContext, HttpServletRequest request, HttpServletResponse response,
			ServletConfig servletConfig) {
		this.servletContext = servletContext;
		this.request = request;
		this.response = response;
		this.servletConfig = servletConfig;
		// 实例化上传组件
		this.su = new SmartUpload();
	}

	public Upload(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	public String[][] uploadAndSave() throws Exception {
		// 设置上传文件保存路径
		String filePath = servletContext.getRealPath("/") + "img\\upload";
		File file = new File(filePath);
		if (!file.exists()) {
			// 如果没有这个文件就创建
			file.mkdir();
		}

		// 初始化SmartUpload
		su.initialize(servletConfig, request, response);
		// 设置上传文件对象10M
		su.setMaxFileSize(1024 * 1024 * 10);
		// 设置所有文件大小100M
		su.setTotalMaxFileSize(1024 * 1024 * 100);

		// 设置禁止上传文件类型
		su.setDeniedFilesList("rar,jsp,js");
		// 上传文件
		su.upload();
		// 返回路径结果数组 全路径:[][0],访问路径:[][1]
		String[][] result = new String[su.getFiles().getCount()][2];

		for (int i = 0; i < su.getFiles().getCount(); i++) {
			if (su.getFiles().getFile(i).getSize() > 0) {
				// 获取文件后缀
				String ext = su.getFiles().getFile(i).getFileExt();
				// 获取时间戳
				String time = DateUtil.timeStamp2();
				// 获取uuid
				UUID uuid = UUID.randomUUID();
				// 文件名称>全路径
				String fileName = filePath + File.separator + time + uuid + "." + ext;
				// 保存文件
				su.getFiles().getFile(i).saveAs(fileName);
				// 放入结果集
				result[i][0] = fileName;
				result[i][1] = "img/upload/" + time + uuid + "." + ext;
			}
		}
		return result;
	}

	// 只上传不保存
	public SmartUpload upload() throws Exception {
		// 设置上传文件保存路径
		String filePath = servletContext.getRealPath("/") + "img\\upload";
		File file = new File(filePath);
		if (!file.exists()) {
			// 如果没有这个文件就创建
			file.mkdir();
		}

		// 初始化SmartUpload
		su.initialize(servletConfig, request, response);
		// 设置上传文件对象10M
		su.setMaxFileSize(1024 * 1024 * 10);
		// 设置所有文件大小100M
		su.setTotalMaxFileSize(1024 * 1024 * 100);

		// 设置禁止上传文件类型
		su.setDeniedFilesList("rar,jsp,js");
		// 上传文件
		su.upload();
		return su;
	}

	// 保存图片
	public String[][] save(SmartUpload smartUpload) throws Exception {
		su = smartUpload;
		// 设置上传文件保存路径
		String filePath = servletContext.getRealPath("/") + "img\\upload";
		File file = new File(filePath);
		if (!file.exists()) {
			// 如果没有这个文件就创建
			file.mkdir();
		}

		// 返回路径结果数组 全路径:[][0],访问路径:[][1]
		String[][] result = new String[su.getFiles().getCount()][2];
		for (int i = 0; i < su.getFiles().getCount(); i++) {
			if (su.getFiles().getFile(i).getSize() > 0) {
				// 获取文件后缀
				String ext = su.getFiles().getFile(i).getFileExt();
				// 获取时间戳
				String time = DateUtil.timeStamp2();
				// 获取uuid
				UUID uuid = UUID.randomUUID();
				// 文件名称>全路径
				String fileName = filePath + File.separator + time + uuid + "." + ext;
				// 保存文件
				su.getFiles().getFile(i).saveAs(fileName);
				// 放入结果集
				result[i][0] = fileName;
				result[i][1] = "img/upload/" + time + uuid + "." + ext;
			}
		}
		return result;
	}

	// 主要用于删除刚上传的文件: 传访问路径
	public void delete(String[][] fileName) {
		for (int i = 0; i < fileName.length; i++) {
			if (fileName[i][1] != null && "".equals(fileName[i][1])) {
				String filePath = servletContext.getRealPath(fileName[i][1]);
				File file = new File(filePath);
				file.delete();
			}
		}
	}

	// 主要用于批量删除旧图片: 传访问路径
	public void delete(String[] fileName) {
		for (int i = 0; i < fileName.length; i++) {
			if (fileName[i] != null && "".equals(fileName[i])) {
				String filePath = servletContext.getRealPath(fileName[i]);
				File file = new File(filePath);
				file.delete();
			}
		}
	}

	// 主要用于删除一张旧图片: 传访问路径
	public void delete(String fileName) {
		if (fileName != null && "".equals(fileName)) {
			String filePath = servletContext.getRealPath(fileName);
			File file = new File(filePath);
			file.delete();
		}
	}

	public Request getRequest() {
		return su.getRequest();
	}

}
