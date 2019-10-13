<%@page import="java.util.List"%>
<%@page import="com.pinxixi.vo.Adviertisement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>

<%-- 基本模型 --%>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="renderer" content="webkit">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- <link href="others/bootstrap/bootstrap.min.css" rel="stylesheet"> -->
<link href="others/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet">
<link href="others/layui/css/layui.css" rel="stylesheet">
<link href="css/utils.css" rel="stylesheet">
<title>拼夕夕 - 首页</title>

<%-- ico引入 --%>
<link rel="Shortcut Icon" href="img/icon.ico" />
<link rel="icon" href="img/icon.ico" />

<%-- 引入页面所需css --%>
<link href="css/index.css" rel="stylesheet">

</head>
<body>
<%-- 	<%String msg=(String)request.getAttribute("msg"); --%>
<%-- if(msg!=null){
<%-- 		  %> --%>
<!-- 		  <script type="text/javascript"> -->
<%-- 		  alert("<%=msg%>"); --%>
<!-- 		  </script> -->
<%-- 		  <% --%>
<!-- // 	  } -->
<%-- 	%> --%>
	<%-- 导航栏 --%>
	<jsp:include page="nav.jsp"></jsp:include>
	
	<%-- 内容部分 --%>
	<div id="banner"></div>
	<div id="advertising">
		<%
		List<Adviertisement> list=(List<Adviertisement>)request.getAttribute("AdList");
		for(int i=0;i<list.size();i++){%>
		<div style="background-image: url('<%=list.get(i).getPath()%>');">
			<div>
				<%=list.get(i).getADDetails() %>
			</div>
		</div>
		<%} %>
		<span class="clear"></span>
	</div>
	<%-- 底部 --%>
	<jsp:include page="footer.jsp"></jsp:include>
	
	<%-- 加载js --%>
	<script src="others/jquery.min.js"></script>
<!-- 	<script src="others/bootstrap/bootstrap.min.js"></script> -->
	<script src="others/layui/layui.js"></script>
	<script src="js/utils.js"></script>
	<script src="js/index.js"></script>
	
</body>
</html>