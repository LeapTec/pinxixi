<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.pinxixi.vo.page.Car"%>
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
<title>拼夕夕 - 购物车</title>

<%-- ico引入 --%>
<link rel="Shortcut Icon" href="img/icon.ico" />
<link rel="icon" href="img/icon.ico" />

<%-- 引入页面所需css --%>
<link href="css/car.css" rel="stylesheet">

</head>
<body>
	<%
	List<Car> carList=(List<Car>)request.getAttribute("carList");
	%>
	<%-- 导航栏 --%>
	<jsp:include page="nav.jsp"></jsp:include>
	
	<%-- 内容部分 --%>
	<div id="cars">
		<form action="OrderEnter" method="post" class="layui-form">
			<table lay-filter="table" class="layui-table" lay-skin="line">
				<thead>
					<tr>
					    <th lay-data="{field : 'CID',title : '#',sort : true,type : 'numbers',fixed : 'left'}"></th>
						<th lay-data="{field:'UID',width:50,type:'checkbox'}"></th>
						<th lay-data="{field:'test1',sort : true,title:'商品'}"></th>
						<th lay-data="{field:'test2',sort : true,title:'单价',width:'14%'}"></th>
						<th lay-data="{field:'number',sort : true,title:'数量',width:'14%'}"></th>
						<th lay-data="{field:'sum',sort : true,title:'小计',width:'14%'}"></th>
					</tr>
				</thead>
				<tbody>
					<%for(int i=0;i<carList.size();i++){ %>
					<tr>
						<td><%=carList.get(i).getCommodity().getCID() %></td>
						<td>i</td>
						<td><%=carList.get(i).getBName()+"  "+carList.get(i).getSName()+"  "+carList.get(i).getSIMType()+
						"  "+carList.get(i).getCommodity().getColor()+"  "+carList.get(i).getStorage()%></td>
<!-- 						<td>魅族16th Plus 全网通公开版 远山白 8+128GB</td> -->
						<td>¥ <%=carList.get(i).getCommodity().getPrice() %></td>
						<td><%=carList.get(i).getShoppingCar().getAmount() %></td>
						<%int amout=carList.get(i).getShoppingCar().getAmount();
						float price=carList.get(i).getCommodity().getPrice();
						float sum=(float)amout*price; %>
						<td>¥ <%=sum %></td>
					</tr>
					<%} %>
				</tbody>
			</table>
			<div id="cars-tobuy">
				<div style="line-height: 34px;">
					<a href="javascript:;" id='del'>删除选中的商品</a>
					<div>共 <span><%=carList.size() %></span> 件商品，已选择 <span>0</span> 件</div>
				</div>
				<div>
					<div>合计（不含运费）：<div>¥ <span id="heji">0.00</span></div></div>
					<div><button type="button" id="gotobuy">去结算</button></div>
					<div style="display: none;" id="CN"></div>
					<button style="display: none;" id="gotobuy2"></button>
				</div>
				<span class="clear"></span>
			</div>
			<input type="hidden" name="where" value="car" />
		</form>
		<form action="ShoppingCarDelete" style="display: none;" method="post"
			id="batchSelect">
			<button></button>
		</form>
	</div>
	
	<%-- 底部 --%>
	<jsp:include page="footer.jsp"></jsp:include>
	
	<%-- 加载js --%>
	<script src="others/jquery.min.js"></script>
<!-- 	<script src="others/bootstrap/bootstrap.min.js"></script> -->
	<script src="others/layui/layui.js"></script>
	<script src="js/utils.js"></script>
	<script src="js/car.js"></script>
	
</body>
</html>