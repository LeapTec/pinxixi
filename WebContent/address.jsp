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

<%-- ico引入 --%>
<link rel="Shortcut Icon" href="img/icon.ico" />
<link rel="icon" href="img/icon.ico" />

<style type="text/css">
	.address-title{
		font-size: 18px;
		padding: 0 0 20px 10px;
	}
</style>
<script type="text/javascript">
	function AddressEdit(){
		
	}
</script>
</head>
<body>
	
	<div style="padding: 15px 10px 0px 10px;">
		<form class="layui-form" action="AddressAdd" method="post" id="addressForm">
			<input type="hidden" name="AID" />
			<input type="hidden" name="UID" />
			<div class="address-title">新增收货地址</div>
			<div class="layui-form-item">
		    	<label class="layui-form-label">收货人</label>
		    	<div class="layui-input-block">
		      		<input type="text" name="AName" required  lay-verify="required" placeholder="请输入收货人姓名" autocomplete="off" class="layui-input">
		    	</div>
		    </div>
			<div class="layui-form-item">
		    	<label class="layui-form-label">联系电话</label>
		    	<div class="layui-input-block">
		      		<input type="text" name="Phone" required  lay-verify="required|phone" placeholder="请输入收货人联系电话" autocomplete="off" class="layui-input">
		    	</div>
		    </div>
			<div class="layui-form-item">
		    	<label class="layui-form-label">所在地区</label>
		    	<div class="layui-input-block">
		    		<%String[] address = {"北京市","天津市","上海市","重庆市","河北省","山西省","辽宁省","吉林省","黑龙江省","江苏省","浙江省","安徽省","福建省","江西省","山东省","河南省","湖北省","湖南省","广东省","海南省","四川省","贵州省","云南省","陕西省","甘肃省","青海省","台湾省","内蒙古自治区","广西壮族自治区","西藏自治区","宁夏回族自治区","新疆维吾尔自治区","香港特别行政区","澳门特别行政区"};%>
			      	<select name="Area" lay-verify="required">
			      		<%for(String a : address){ %>
			         	<option value="<%=a %>"><%=a %></option>
			         	<%} %>
			      	</select>
		    	</div>
		    </div>
			<div class="layui-form-item">
		    	<label class="layui-form-label">详细地址</label>
		    	<div class="layui-input-block">
		      		<input type="text" name="Address" required  lay-verify="required" placeholder="请输入收货人详细地址" autocomplete="off" class="layui-input">
		    	</div>
		    </div>
		    <div class="layui-form-item">
			    <div class="layui-input-block">
			        <button class="layui-btn" lay-submit lay-filter="submit">保存</button>
			        <button class="layui-btn layui-btn-primary" type="button" id="goAdd" style="display: none;">回到新增</button>
			        <button type="reset" style="display: none;" id="resetForm"></button>
			    </div>
			</div>
			<div style="border-top: 1px dashed #dedede;margin-bottom: 20px;"></div>
		</form>
		<c:forEach items="${requestScope.list }" var="a">
			<div class="layui-card">
			    <div class="layui-card-header">${a.AName }</div>
			    <div class="layui-card-body">
			    	<div>${a.area }${a.address }<br>${a.phone }</div>
			    	<div style="text-align: right;">
			    		<a href="javascript:;" style="margin: 0 10px;" class="editAddress">编辑</a>
			    		<a href="javascript:;" style="margin: 0 10px;" class="delAddress">删除</a>
			    	</div>
			    	<span style="display: none;">
						<span>${a.AID }</span>
						<span>${a.AName }</span>
						<span>${a.phone }</span>
						<span>${a.area }</span>
						<span>${a.address }</span>
						<span>${a.UID }</span>
			    	</span>
			    </div>
			</div>
		</c:forEach>
		<div style="margin-bottom: 70px;"></div>
	</div>
	
	<%-- 加载js --%>
	<script src="others/jquery.min.js"></script>
<!-- 	<script src="others/bootstrap/bootstrap.min.js"></script> -->
	<script src="others/layui/layui.js"></script>
	<script src="js/utils.js"></script>
	
	<script type="text/javascript">
	$(document).ready(function(){
		layui.use(['form','layer'], function(){
			var form = layui.form;
			var layer = layui.layer;
			$('.editAddress').click(function(){
				var msg = $(this).parent().next().find('span');
				$('#addressForm input[name="AID"]').val($(msg[0]).html());
				$('#addressForm input[name="AName"]').val($(msg[1]).html());
				$('#addressForm input[name="Phone"]').val($(msg[2]).html());
				// 赋值给select
				$("#addressForm select[name='Area']").val($(msg[3]).html());
				// 更新form
				form.render("select");
				$('#addressForm input[name="Address"]').val($(msg[4]).html());
				$('#addressForm input[name="UID"]').val($(msg[5]).html());
				// 修改标题
				$('#addressForm>div:nth-of-type(1)').html("修改收货地址");
				// 修改form表单的action值
				$('#addressForm').attr('action','AddressEdit');
				// 添加回到新增的按钮
				$('#goAdd').attr('style','');
			});
			$('#goAdd').click(function(){
				$('#resetForm').click();
				$('#goAdd').hide();
				$('#addressForm').attr('action','AddressAdd');
				$('#addressForm>div:nth-of-type(1)').html("新增收货地址");
			});
			$('.delAddress').click(function(){
				var dom = this;
				var layerOpen = layer.open({
					content : "确认删除吗？",
					title : "删除地址",
					btn : [ '确定', '取消' ],
					resize: false,
					shadeClose: true,
					yes : function(index, layero) {
						layer.close(layerOpen);
						var msg = $(dom).parent().next().find('span');
						window.location.href="AddressDelete?AID="+$(msg[0]).html();
					}
				});
			});
		});
	});
	</script>
</body>
</html>