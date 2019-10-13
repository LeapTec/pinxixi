<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
    <%@page import="java.util.List"%>
    <%@page import="com.pinxixi.vo.page.*"%>
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
<title>拼夕夕 - 我的订单</title>

<%-- ico引入 --%>
<link rel="Shortcut Icon" href="img/icon.ico" />
<link rel="icon" href="img/icon.ico" />

<%-- 引入页面所需css --%>
<link href="css/orders.css" rel="stylesheet">

</head>
<body>
	<% List<UserOrders> list = (List<UserOrders>) request.getAttribute("MyOrdersList"); %>
	<%-- 导航栏 --%>
	<jsp:include page="nav.jsp"></jsp:include>
	
	<%-- 内容部分 --%>
	<div id="orders-block">
		<form action="" method="post" class="layui-form">
			<table class="layui-table">
			  <tbody>
			  	<%for(int i=0;i<list.size();i++){ %>
			    <tr>
			      <td>
			      	<div>
			      		<div class="orders-block-hui">订单号：<span class="orders-block-hei"><%=list.get(i).getOrders().getOID() %></span></div>
		      			<div id="aaa">
		      				<% 
		      					String ordersStatus = list.get(i).getOrders().getStatus();
		      					// 0: 未评论,1: 已评论
		      					Integer evaluationStatus = list.get(i).getEvaluationStatus();
		      					if(ordersStatus.indexOf("退货中") < 0 && !"已取消".equals(ordersStatus)){%>
		      						<a href="javascript:;" class="toth" id="<%=list.get(i).getOrders().getOID()%>">退货</a>
      						<%	}
		      					if(ordersStatus.indexOf("退货中") > -1){%>
		      						<a href="javascript:;" class="toqt" id="<%=list.get(i).getOrders().getOID()%>">取消退货</a>
      						<%	}
		      					if("已签收".equals(ordersStatus)
	      							&& evaluationStatus == 0){%>
		      						<a href="javascript:;" class="topj" id="<%=list.get(i).getOrders().getOID()%>">点击评价</a>
	      					<%	}
		      					if("已发货".equals(ordersStatus)){%>
		      						<a href="javascript:;" class="toqr" id="<%=list.get(i).getOrders().getOID()%>">确认收货</a>
	      					<%	}%>
			      		</div>
						      		<span class="clear"></span>
						      	</div>
			      		
			      	<%float ef=list.get(i).getOrders().getExpressFee();
			      		  float pr=list.get(i).getCommodity().getPrice();
			      		  int qt=list.get(i).getOrders().getQuantity();
			      		  float sum=qt*pr+ef;%>
			      	<div>
			      		<div>
				      		<span><%=list.get(i).getBName()+" "+list.get(i).getSName()+" "+list.get(i).getModel().getSIMType()+" "+list.get(i).getCommodity().getColor()+" "+list.get(i).getModel().getRAM()+"G+"+list.get(i).getModel().getROM()+"G" %></span>
				      		<span>¥ <%=pr+" × "+qt %></span>
			      		</div>
			      		<div>
			      		
			      			<span class="orders-block-hui">运费：<span class="orders-block-hei">¥ <%=ef %></span></span>
			      			<span class="orders-block-hui">总价：<span class="orders-block-hong">¥ <%=sum %></span></span>
			      			<span class="orders-block-hui">状态：<span class="orders-block-hei"><%=list.get(i).getOrders().getStatus().indexOf("退货中") < 0 ? list.get(i).getOrders().getStatus() : list.get(i).getOrders().getStatus().split("-")[1] %></span></span>
			      		</div>
			      		<div>
			      			<span class="orders-block-hui">下单时间：<span class="orders-block-hei"><%=list.get(i).getOrders().getOrderTime() %></span></span>
			      			<span class="orders-block-hui">支付时间：<span class="orders-block-hei"><%=list.get(i).getOrders().getPayTime() %></span></span>
			      			<span class="orders-block-hui">发货时间：<span class="orders-block-hei"><%=list.get(i).getOrders().getDeliveryTime() != null ? list.get(i).getOrders().getDeliveryTime():"" %></span></span>
			      			<span class="orders-block-hui">快递单号：<span class="orders-block-hei"><%=list.get(i).getOrders().getTrackNum() %></span></span>
			      		</div>
			      		<span class="clear"></span>
			      	</div>
			      	<div><%=list.get(i).getAddress().getAName()+" "+list.get(i).getAddress().getPhone()+" "+list.get(i).getAddress().getArea()+list.get(i).getAddress().getAddress() %></div>
			      </td>
			    </tr>
			    <%} %>
			  </tbody>
			</table>
			<c:if test="${requestScope.MyOrdersList.size() < 1 }">
				<div style="width: 100%;text-align: center;font-size: 20px;margin-top: 200px;color: #999;">咦？怎么这里空空如也呢？快去下单吧！</div>
			</c:if>
		</form>
	</div>
	
	<%-- 底部 --%>
	<jsp:include page="footer.jsp"></jsp:include>
	
	<%-- 加载js --%>
	<script src="others/jquery.min.js"></script>
<!-- 	<script src="others/bootstrap/bootstrap.min.js"></script> -->
	<script src="others/layui/layui.js"></script>
	<script src="js/utils.js"></script>
	<script src="js/orders.js"></script>
	
</body>
</html>