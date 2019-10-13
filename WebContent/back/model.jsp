<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.pinxixi.vo.Model"%>
<%@page import="java.util.List"%>
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
<title>拼夕夕后台 - 分类管理 - 型号</title>

<%-- ico引入 --%>
<link rel="Shortcut Icon" href="../img/icon.ico" />
<link rel="icon" href="../img/icon.ico" />

<%-- 引入页面所需css --%>
<link href="../css/back-model.css" rel="stylesheet">

</head>
<body class="layui-layout-body">
<%-- 	<%List<Model> list = (List<Model>)request.getAttribute("ModelList"); %> --%>
	<div class="layui-layout layui-layout-admin">	
		<%-- 头部 --%>
		<jsp:include page="head.jsp"></jsp:include>

		<%-- 左侧导航栏 --%>
		<jsp:include page="nav.jsp"></jsp:include>
		
		<%-- 主体内容区域 --%>
		<div class="layui-body">
			<fieldset class="layui-elem-field layui-field-title">
				<legend>型号管理</legend>
			</fieldset>
			<div class="layui-row layui-col-space15">
				<div class="layui-col-xs12">
					<%-- 添加型号 --%>
					<div class="layui-card">
						<div class="layui-card-header">添加型号</div>
						<div class="layui-card-body layui-row layui-col-space10">
							<div class="layui-col-xs12">
								<button class="layui-btn" type="button" id="addmodel">添加型号</button>
							</div>
						</div>
					</div>
					<%-- 搜索框 --%>
					<div class="layui-card">
						<div class="layui-card-header">型号查询</div>
						<div class="layui-card-body layui-row layui-col-space10">
							<div class="layui-col-xs12">
								<form class="layui-form" action="BackModel" method="post">
									<div class="layui-col-xs10">
										<input name="conditions" autocomplete="off" type="text" class="layui-input">
									</div>
									<div class="layui-col-xs2" style="text-align: center;">
										<button class="layui-btn"  lay-submit lay-filter="" style="width: 100%;">查询</button>
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
											<th lay-data="{field : 'MID',title : '#',sort : true,type : 'numbers',fixed : 'left'}"></th>
											<th lay-data="{field:'MID',width:50,type:'checkbox',fixed : 'left'}"></th>
											<th lay-data="{field:'SName',sort : true,title:'系列名',width: 150}"></th>
											<th lay-data="{field:'Size',sort : true,title:'屏幕尺寸',width: 150}"></th>
											<th lay-data="{field:'Resolution',sort : true,title:'屏幕分辨率',width: 150}"></th>
											<th lay-data="{field:'OS',sort : true,title:'系统',width: 150}"></th>
											<th lay-data="{field:'RAM',sort : true,title:'运行内存',width: 150}"></th>
											<th lay-data="{field:'ROM',sort : true,title:'机身内存',width: 150}"></th>
											<th lay-data="{field:'FrontCamera',sort : true,title:'前置摄像头',width: 150}"></th>
											<th lay-data="{field:'RearCamera',sort : true,title:'后置摄像头',width: 150}"></th>
											<th lay-data="{field:'Battery',sort : true,title:'电池容量',width: 150}"></th>
											<th lay-data="{field:'SOC',sort : true,title:'系统级芯片',width: 150}"></th>
											<th lay-data="{field:'Thickness',sort : true,title:'厚度',width: 150}"></th>
											<th lay-data="{field:'SIMType',sort : true,title:'SIM卡类型',width: 150}"></th>
											<th lay-data="{title : '操作',width : 80,toolbar : '#tableBar',unresize : true,align : 'center',fixed : 'right'}"></th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${requestScope.ModelList }" var="m">
											<tr>
												<td>${m.model.MID }</td>
												<td>${m.model.MID }</td>
												<td>${m.SName }</td>
												<td>${m.model.size }</td>
												<td>${m.model.resolution }</td>
												<td>${m.model.OS }</td>
												<td>${m.model.RAM }</td>
												<td>${m.model.ROM }</td>
												<td>${m.model.frontCamera }</td>
												<td>${m.model.rearCamera }</td>
												<td>${m.model.battery }</td>
												<td>${m.model.SOC }</td>
												<td>${m.model.thickness }</td>
												<td>${m.model.SIMType }</td>
												<td></td>
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
								<form class="layui-form" action="BackModelDel" method="post" id="batchSelect">
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
	
	<script type="text/html" id="tableBar">
		<a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
	</script>
	
	<%-- 加载js --%>
	<script src="../others/jquery.min.js"></script>
<!-- 	<script src="../others/bootstrap/bootstrap.min.js"></script> -->
	<script src="../others/layui/layui.js"></script>
	<script src="../js/back-utils.js"></script>
	<script src="../js/back-model.js"></script>
	
</body>
</html>