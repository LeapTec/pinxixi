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
<!-- <link href="../others/bootstrap/bootstrap.min.css" rel="stylesheet"> -->
<link href="../others/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet">
<link href="../others/layui/css/layui.css" rel="stylesheet">
<link href="../css/back-utils.css" rel="stylesheet">

<%-- ico引入 --%>
<link rel="Shortcut Icon" href="../img/icon.ico" />
<link rel="icon" href="../img/icon.ico" />

</head>
<body>
	
	<div style="padding: 15px 10px 0px 10px;">
		<form class="layui-form" action="BackSeriesUpdate" method="post" style="text-align: center;">
			<input type="hidden" name="SID" value="${requestScope.s.SID }" />
			<select name="BID" lay-verify="required" lay-filter="">
				<c:forEach items="${requestScope.b }" var="b">
					<option value="${b.BID }" <c:if test="${b.BID eq requestScope.s.BID }">selected</c:if>>${b.BName }</option>
				</c:forEach>
			</select>
      		<input type="text" name="SName" value="${requestScope.s.SName}" required  lay-verify="required"
      		 placeholder="请填写系列名" autocomplete="off" class="layui-input" style="margin-top: 10px;margin-bottom: 10px;">
	        <button class="layui-btn" lay-submit lay-filter="submit">保存</button>
		</form>
	</div>
	
	<%-- 加载js --%>
	<script src="../others/jquery.min.js"></script>
<!-- 	<script src="../others/bootstrap/bootstrap.min.js"></script> -->
	<script src="../others/layui/layui.js"></script>
	<script src="../js/back-utils.js"></script>
	
	<script type="text/javascript">
	$(document).ready(function(){
		layui.use(['form'], function(){
			var form = layui.form;
		});
	});
	</script>
</body>
</html>