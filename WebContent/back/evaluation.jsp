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
<title>拼夕夕后台 - 评论管理</title>

<%-- ico引入 --%>
<link rel="Shortcut Icon" href="../img/icon.ico" />
<link rel="icon" href="../img/icon.ico" />

<%-- 引入页面所需css --%>
<link href="../css/back-evaluation.css" rel="stylesheet">

</head>
<body class="layui-layout-body">
	<div class="layui-layout layui-layout-admin">
		<%-- 头部 --%>
		<jsp:include page="head.jsp"></jsp:include>

		<%-- 左侧导航栏 --%>
		<jsp:include page="nav.jsp"></jsp:include>
		
		<%-- 主体内容区域 --%>
		<div class="layui-body">
			<fieldset class="layui-elem-field layui-field-title">
				<legend>评论管理</legend>
			</fieldset>
			<div class="layui-row layui-col-space15">
				<div class="layui-col-xs12">
					<%-- 搜索框 --%>
					<div class="layui-card">
						<div class="layui-card-header">评论查询</div>
						<div class="layui-card-body layui-row layui-col-space10">
							<div class="layui-col-xs12">
								<form class="layui-form" action="BackEvaluation" method="post">
									<div class="layui-col-xs10">
										<input name="conditions" value="${requestScope.conditions }" autocomplete="off" type="text" class="layui-input">
									</div>
									<div class="layui-col-xs2" style="text-align: center;">
										<button class="layui-btn" style="width: 100%;">查询</button>
									</div>
								</form>
							</div>
						</div>
					</div>
					<%-- 查询结果 --%>
					<div class="layui-card">
						<div class="layui-card-header">查询结果</div>
						<div class="layui-card-body layui-row layui-col-space10">
							<div class="layui-col-xs12">
								<table lay-filter="table">
									<thead>
										<tr>
											<th lay-data="{field : 'EID',title : '#',sort : true,type : 'numbers',fixed : 'left'}"></th>
											<th lay-data="{field:'EID',width:50,type:'checkbox',fixed : 'left'}"></th>
											<th lay-data="{field:'OID',sort : true,title:'订单ID'}"></th>
											<th lay-data="{field:'PublishDate',sort : true,title:'发表日期'}"></th>
											<th lay-data="{field:'EvaDetails',sort : true,title:'评价详情'}"></th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${requestScope.list }" var="e">
											<tr>
												<td>${e.EID }</td>
												<td>${e.EID }</td>
												<td>${e.OID }</td>
												<td>${e.publishDate }</td>
												<td>${e.evaDetails }</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>
					<%-- 批量操作 --%>
					<div class="layui-card">
						<div class="layui-card-header">批量操作</div>
						<div class="layui-card-body layui-row layui-col-space10">
							<div class="layui-col-xs12">
								<form class="layui-form" action="BackEvaluationDel" method="post" id="batchSelect">
									<div class="layui-inline">
										<div class="layui-input-inline" style="width: 180px;">
											<select name="batchSelect" lay-verify="required" lay-filter="batchSelect">
												<option value="del">批量删除</option>
											</select>
										</div>
										<div class="layui-input-inline">
											<button class="layui-btn" type="button" lay-submit lay-filter="executeList">执行</button>
											<button style="display: none;" type="submit"></button>
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<%-- 加载js --%>
	<script src="../others/jquery.min.js"></script>
<!-- 	<script src="../others/bootstrap/bootstrap.min.js"></script> -->
	<script src="../others/layui/layui.js"></script>
	<script src="../js/back-utils.js"></script>
	<script src="../js/back-evaluation.js"></script>
	
</body>
</html>