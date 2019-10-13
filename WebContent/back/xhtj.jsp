<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="com.pinxixi.vo.*"%>
<%@page import="java.util.*"%>
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
	<% List<Series> list = (List<Series>)request.getAttribute("SeriesList");
// 	System.out.println("页面拿到的系列");
// 		for(Series a:list){
// 			System.out.println(a.toString());
// 		}
	%>
	<div style="padding: 15px 10px 0px 10px;">
		<form class="layui-form" action="BackModelAdd" method="post" enctype="multipart/form-data">
	        <button class="layui-btn" type="button" id="button1" lay-submit lay-filter="submit">保存</button>
        	<div style="border-bottom: 1px dashed #dedede;margin: 10px 0;"></div>
			<div class="layui-col-xs12">
				<div class="layui-col-xs6" style="padding: 0 5px;">
					<select name="SID" lay-verify="required" lay-filter="">
						<option value="">--请选择系列--</option>
						<%
							for(Series s:list){%>
								<option value="<%=s.getSID() %>"><%=s.getSName() %></option>
							<%}
						%>
					</select>
					<input type="text" name="Size" required  lay-verify="required"
      		 		placeholder="请填写屏幕尺寸" autocomplete="off" class="layui-input" style="margin-top: 10px;margin-bottom: 10px;">
					<input type="text" name="Resolution" required  lay-verify="required"
      		 		placeholder="请填写屏幕分辨率" autocomplete="off" class="layui-input" style="margin-bottom: 10px;">
					<input type="text" name="OS" required  lay-verify="required"
      		 		placeholder="请填写系统" autocomplete="off" class="layui-input" style="margin-bottom: 10px;">
					<input type="number" name="RAM" required  lay-verify="required|number"
      		 		placeholder="请填写运行内存" autocomplete="off" class="layui-input" style="margin-bottom: 10px;">
					<input type="number" name="ROM" required  lay-verify="required|number"
      		 		placeholder="请填写机身内存" autocomplete="off" class="layui-input" style="margin-bottom: 10px;">
				</div>
				<div class="layui-col-xs6" style="padding: 0 5px;">
					<input type="text" name="FrontCamera" required  lay-verify="required"
      		 		placeholder="请填写前置摄像头" autocomplete="off" class="layui-input" style="margin-bottom: 10px;">
					<input type="text" name="RearCamera" required  lay-verify="required"
      		 		placeholder="请填写后置摄像头" autocomplete="off" class="layui-input" style="margin-bottom: 10px;">
					<input type="number" name="Battery" required  lay-verify="required|number"
      		 		placeholder="请填写电池容量" autocomplete="off" class="layui-input" style="margin-bottom: 10px;">
					<input type="text" name="SOC" required  lay-verify="required"
      		 		placeholder="请填写系统级芯片" autocomplete="off" class="layui-input" style="margin-bottom: 10px;">
					<input type="text" name="Thickness" required  lay-verify="required"
      		 		placeholder="请填写厚度" autocomplete="off" class="layui-input" style="margin-bottom: 10px;">
					<input type="text" name="SIMType" required  lay-verify="required"
      		 		placeholder="请填写SIM卡类型" autocomplete="off" class="layui-input" style="margin-bottom: 10px;">
				</div>
			</div>
			<span class="clear"></span>
			<div style="border-bottom: 1px dashed #dedede;margin: 10px 0;"></div>
			<div class="layui-col-xs12" style="margin-bottom: 75px;">
				<script id="ue" type="text/plain"></script>
			</div>
			<input type="hidden" name="Details" />
			<button style="display: none;" id="button2"></button>
		</form>
	</div>
	
	<%-- 加载js --%>
	<script src="../others/jquery.min.js"></script>
	<script src="../others/ue/ueditor.config.js"></script>
	<script src="../others/ue/ueditor.all.min.js"></script>
<!-- 	<script src="../others/bootstrap/bootstrap.min.js"></script> -->
	<script src="../others/layui/layui.js"></script>
	<script src="../js/back-utils.js"></script>
	
	<script type="text/javascript">
	$(document).ready(function(){
		layui.use(['form','layer'], function(){
			var form = layui.form;
			var layer = layui.layer;
			var ue = UE.getEditor('ue');
			ue.ready(function(){
				 $('#button1').click(function(){
					 if(ue.getContent() == ''){
						 layer.msg("请输入商品详情");
					 }else{
						 $('input[name="Details"]').val(ue.getContent());
						 $('#button2').click();
					 }
				 });
			});
		});
	});
	</script>
</body>
</html>