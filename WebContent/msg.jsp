<%@page import="com.pinxixi.vo.Users"%>
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
	<%
	Users user=(Users)request.getAttribute("User");
	%>
	<div style="padding: 15px 10px 0px 10px;">
		<form class="layui-form" action="UsersUpdate" method="post">
			<div class="layui-form-item">
		    	<label class="layui-form-label">用户名</label>
		    	<div class="layui-input-block">
		      		<input type="text" name="UName" value="<%=user.getUName()%>" required  lay-verify="required" placeholder="请输入用户名" autocomplete="off" class="layui-input">
		    	</div>
		    </div>
		    <div class="layui-form-item">
			    <label class="layui-form-label">性别</label>
			    <div class="layui-input-block">
			      <input type="radio" name="Sex" value="男" title="男" <%if(user.getSex().equals("男")){%>
			    	  checked
			     <% }
			      %> >
			      <input type="radio" name="Sex" value="女" title="女" <%if(user.getSex().equals("女")){%>
			    	  checked
			     <% }
			      %>>
			    </div>
			</div>
			<div class="layui-form-item">
			    <label class="layui-form-label">证件类型</label>
			    <div class="layui-input-block">
			      	<select name="UNType" lay-verify="required">
			         	<option value="身份证" <%if(user.getUNType().equals("身份证")){ %>
			         	  selected	
			         <% 	} %> >身份证</option>
			         	<option value="护照" <%if(user.getUNType().equals("护照")){ %>
			         	  selected	
			         <% 	} %> >护照</option>
			         	<option value="居住证" <%if(user.getUNType().equals("居住证")){ %>
			         	  selected	
			         <% 	} %> >居住证</option>
			      	</select>
			    </div>
			</div>
			<div class="layui-form-item">
		    	<label class="layui-form-label">证件号</label>
		    	<div class="layui-input-block">
		      		<input type="text" name="UNumber" value="<%=user.getUNumber()%>" required  lay-verify="required" placeholder="请输入证件号" autocomplete="off" class="layui-input">
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