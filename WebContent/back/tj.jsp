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
		<form class="layui-form" action="BackSelectSale" method="post">
			<div class="layui-col-xs12">
				<div class="layui-col-xs6" style="padding: 0 5px;">
					<div style="line-height: 38px;">
						<span>销售额：</span>
						<span style="font-size: 28px;">¥ ${requestScope.sum}</span>
					</div>
				</div>
				<div class="layui-col-xs6" style="padding: 0 5px;text-align: right;">
			        <button class="layui-btn" lay-submit lay-filter="submit">统计</button>
				</div>
			</div>
			<span class="clear"></span>
			<div style="border-bottom: 1px dashed #dedede;margin: 10px 0;"></div>
			<div class="layui-col-xs12">
				<div class="layui-col-xs6" style="padding: 0 5px;">
					<input type="text" name="time" class="layui-input" id="time" value='${requestScope.time}' readonly />
				</div>
				<div class="layui-col-xs6" style="padding: 0 5px;">
					<select name="BID" lay-verify="required">
					    <option value="0">--所有品牌--</option>
					    <c:forEach items="${requestScope.list }" var="b">
					    <option value="${b.BID }" <c:if test="${b.BID eq requestScope.BID }">selected</c:if>>${b.BName }</option>
					    </c:forEach>
					</select>
				</div>
			</div>
		</form>
	</div>
	
	<%-- 加载js --%>
	<script src="../others/jquery.min.js"></script>
<!-- 	<script src="../others/bootstrap/bootstrap.min.js"></script> -->
	<script src="../others/layui/layui.js"></script>
	<script src="../js/back-utils.js"></script>
	
	<script type="text/javascript">
	$(document).ready(function(){
		layui.use(['form','laydate'], function(){
			var form = layui.form;
			var laydate = layui.laydate;
			laydate.render({
				elem: '#time',
				type: 'datetime',
				range: '~',
				calendar: true,
			});
		});
	});
	</script>
</body>
</html>