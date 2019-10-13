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
<title>拼夕夕 - 确认订单</title>

<%-- ico引入 --%>
<link rel="Shortcut Icon" href="img/icon.ico" />
<link rel="icon" href="img/icon.ico" />

<%-- 引入页面所需css --%>
<link href="css/addorders.css" rel="stylesheet">

</head>
<body>
	
	<%-- 导航栏 --%>
	<jsp:include page="nav.jsp"></jsp:include>
	
	<%-- 内容部分 --%>
	<div id="addorders-block">
		<form action="OrderAdd" method="post" class="layui-form">
			<div class="layui-card">
			    <div class="layui-card-header">收货人信息</div>
			    <div class="layui-card-body" id="addressClick">
			    	<c:forEach items="${requestScope.list }" var="list" varStatus="status">
			    	<div <c:if test="${status.index == 0 }">class="click"</c:if> id="${list.AID }">
			    		<div>
			    			<span>${list.AName }</span>
			    			<span>${list.phone }</span>
			    			<span class="clear"></span>
			    		</div>
			    		<div>${list.area }${list.address }</div>
			    	</div>
			    	</c:forEach>
			    </div>
			</div>
			<div class="layui-card">
			    <div class="layui-card-header">确认订单信息</div>
			    <div class="layui-card-body">
			    	<table class="layui-table">
					  <colgroup>
					    <col>
					    <col width="14%">
					    <col width="10%">
					    <col width="14%">
					    <col width="14%">
					  </colgroup>
					  <thead>
					    <tr>
					      <th>供应商: 拼夕夕</th>
					      <th>单价</th>
					      <th>数量</th>
					      <th>运费</th>
					      <th>小计</th>
					    </tr> 
					  </thead>
					  <tbody>
					  	<c:forEach items="${requestScope.OEM }" var="oem">
					    <tr>
					      <td>${oem.msg }</td>
					      <td>¥ ${oem.danjia }</td>
					      <td>${oem.number }</td>
					      <td class="red">¥ ${oem.yunfei }</td>
					      <td class="red">¥ ${oem.xiaoji }</td>
					    </tr>
					  	</c:forEach>
					    <tr>
					    	<td colspan="5" align="right">合计：<span class="red">¥ ${requestScope.heji }</span></td>
					    </tr>
					  </tbody>
					</table>
			    </div>
			</div>
			<div class="layui-card">
			    <div class="layui-card-header">选择支付方式</div>
			    <div class="layui-card-body">
			    	<div>
			    		<%String[] zhifu = {"蚂蚁花呗","支付宝","微信支付","中国银行","中国建设银行","中国农业银行","中国工商银行","交通银行","招商银行","中国邮政储蓄银行","兴业银行","上海银行"}; %>
			    		<div class="layui-form-item">
					    	<label class="layui-form-label" style="color: #595959;">支付宝</label>
					    	<div class="layui-input-block">
					        	<input type="radio" name="zhifu" value="<%=zhifu[0] %>" title="<%=zhifu[0] %>" checked>
					        	<input type="radio" name="zhifu" value="<%=zhifu[1] %>" title="<%=zhifu[1] %>">
				     		</div>
				  		</div>
			    		<div class="layui-form-item">
					    	<label class="layui-form-label" style="color: #595959;">微信</label>
					    	<div class="layui-input-block">
					        	<input type="radio" name="zhifu" value="<%=zhifu[2] %>" title="<%=zhifu[2] %>">
				     		</div>
				  		</div>
			    		<div class="layui-form-item">
					    	<label class="layui-form-label" style="color: #595959;">网上银行</label>
					    	<div class="layui-input-block">
					    		<%for(int i=3;i<zhifu.length;i++){ %>
					        	<input type="radio" name="zhifu" value="<%=zhifu[i] %>" title="<%=zhifu[i] %>">
					        	<%} %>
				     		</div>
				  		</div>
			    	</div>
			    	<div style="text-align: right;" id="yinfu">
			    		<div style="display: inline-block;text-align: left;">
			    			<span class="yinfu-font">运费：<span>¥ ${requestScope.OEM.size() * 10 }.0</span></span>
			    			<span class="yinfu-font">总金额：<span>¥ ${requestScope.heji }</span></span>
			    			<hr>
			    			<div class="yinfu-font">应付：<span>¥ ${requestScope.heji }</span></div>
			    			<div style="text-align: right;">
			    				<button>下单并支付</button>
			    			</div>
			    		</div>
			    	</div>
			    </div>
			</div>
			<input type="hidden" name="AID" value="${requestScope.list[0].AID }" />
			<c:forEach items="${requestScope.OEM }" var="oem">
			<input type="hidden" name="CN" value="${oem.CID }-${oem.number}" />
			</c:forEach>
			<input type="hidden" name="where" value="<%=request.getParameter("where") %>" />
		</form>
	</div>
	
	<%-- 底部 --%>
	<jsp:include page="footer.jsp"></jsp:include>
	
	<%-- 加载js --%>
	<script src="others/jquery.min.js"></script>
<!-- 	<script src="others/bootstrap/bootstrap.min.js"></script> -->
	<script src="others/layui/layui.js"></script>
	<script src="js/utils.js"></script>
	<script src="js/addorders.js"></script>
	
</body>
</html>