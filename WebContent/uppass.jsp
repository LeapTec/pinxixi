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
<!-- <link href="others/bootstrap/bootstrap.min.css" rel="stylesheet"> -->
<link href="others/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet">
<link href="others/layui/css/layui.css" rel="stylesheet">
<link href="css/utils.css" rel="stylesheet">

<%-- ico引入 --%>
<link rel="Shortcut Icon" href="img/icon.ico" />
<link rel="icon" href="img/icon.ico" />

</head>
<body style="overflow: hidden;">
	
	<div style="padding: 15px 10px 0px 10px;">
		<form class="layui-form" action="UserPassUpdate" method="post">
			<div class="layui-form-item">
		    	<label class="layui-form-label">旧的密码</label>
		    	<div class="layui-input-block">
		      		<input type="password" name="UPassword1" required  lay-verify="required" placeholder="请输入旧的密码" autocomplete="off" class="layui-input">
		    	</div>
		    </div>
			<div class="layui-form-item">
		    	<label class="layui-form-label">新的密码</label>
		    	<div class="layui-input-block">
		      		<input type="password" name="UPassword2" required  lay-verify="required" placeholder="请输入新的密码" autocomplete="off" class="layui-input">
		    	</div>
		    </div>
			<div class="layui-form-item">
		    	<label class="layui-form-label">确认密码</label>
		    	<div class="layui-input-block">
		      		<input type="password" name="UPassword3" required  lay-verify="required" placeholder="再次输入新的密码" autocomplete="off" class="layui-input">
		    	</div>
		    </div>
		    <div class="layui-form-item">
			    <div class="layui-input-block">
			        <button class="layui-btn" lay-submit lay-filter="submit">保存</button>
			    </div>
			</div>
		</form>
	</div>
	
	<%-- 加载js --%>
	<script src="others/jquery.min.js"></script>
<!-- 	<script src="others/bootstrap/bootstrap.min.js"></script> -->
	<script src="others/layui/layui.js"></script>
	<script src="js/utils.js"></script>
	
	<script type="text/javascript">
	$(document).ready(function(){
		layui.use(['form'], function(){
			var form = layui.form;
		});
	});
	</script>
</body>
</html>