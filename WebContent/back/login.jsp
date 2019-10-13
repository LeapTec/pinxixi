<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<title>拼夕夕后台 - 登录</title>

<%-- ico引入 --%>
<link rel="Shortcut Icon" href="../img/icon.ico" />
<link rel="icon" href="../img/icon.ico" />

<%-- 引入页面所需css --%>
<link href="../css/back-login.css" rel="stylesheet">

</head>
<body class="layui-layout-body">
	<div class="layui-card">
	    <div class="layui-card-header">欢迎登录</div>
	    <div class="layui-card-body">
	    	<form class="layui-form" action="BackLogin" method="post">
	    		<input type="text" name="UName" required  lay-verify="required" placeholder="请输入用户名" autocomplete="off" class="layui-input">
	    		<input type="password" name="UPassword" required  lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
	    		<button class="layui-btn" lay-submit lay-filter="submit">登录</button>
	    	</form>
	    </div>
	</div>
	
	<%-- 加载js --%>
	<script src="../others/jquery.min.js"></script>
<!-- 	<script src="../others/bootstrap/bootstrap.min.js"></script> -->
	<script src="../others/layui/layui.js"></script>
	<script src="../js/back-utils.js"></script>
	<script src="../js/back-login.js"></script>
	
</body>
</html>