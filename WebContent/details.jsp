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
<title>拼夕夕 - 商品详情</title>

<%-- ico引入 --%>
<link rel="Shortcut Icon" href="img/icon.ico" />
<link rel="icon" href="img/icon.ico" />

<%-- 引入页面所需css --%>
<link href="css/details.css" rel="stylesheet">

</head>
<body>
	<%-- 导航栏 --%>
	<jsp:include page="nav.jsp"></jsp:include>
	
	<%-- 内容部分 --%>
	<div id="details-title"></div>
	<div id="details-buy">
		<div>
			<div id="details-buy-left">
				<div>
					<div class="layui-carousel" id="details-banner">
						<div carousel-item></div>
					</div>
				</div>
			</div>
			<div id="details-buy-right">
				<div>
				 	<form action="" method="post" class="layui-form">
						<div></div>
						<div></div>
						<div>
							<div>
								<span>¥ </span>
								<span></span>
							</div>
							<div></div>
						</div>
						<div></div>
						<div>
							<div class="layui-form-item">
						    	<label class="layui-form-label">库存</label>
						    	<div class="layui-input-block" style="line-height: 38px;"></div>
						    </div>
							<div class="layui-form-item">
						    	<label class="layui-form-label">颜色分类</label>
						    	<div class="layui-input-block">
									<select name="color" lay-verify="required" lay-filter="color"></select>
						    	</div>
						    </div>
							<div class="layui-form-item">
						    	<label class="layui-form-label">选择规格</label>
						    	<div class="layui-input-block">
									<select name="spe" lay-verify="required" lay-filter="spe"></select>
						    	</div>
						    </div>
							<div class="layui-form-item">
						    	<label class="layui-form-label">数量</label>
						    	<div class="layui-input-block">
						    		<input id="buyNumber" type="number" name="number" min="1" max="999" value="1" required lay-verify="required|number" autocomplete="off" class="layui-input">
		    					</div>
						    </div>
						</div>
						<div id="buttonTo">
							<button type="button" id="tobuy">立即购买</button>
							<button type="button" id="tocar">加入购物车</button>
							<button id="details-buy-button" style="display: none;"></button>
							<input type="hidden" name="CID" />
							<input type="hidden" name="SID" />
							<input type="hidden" name="CIDNUM" />
						</div>
				 	</form>
				</div>
			</div>
			<span class="clear"></span>
		</div>
	</div>
	<div id="details-tabs">
		<div class="layui-tab layui-tab-card">
		  <ul class="layui-tab-title">
		    <li class="layui-this">详情</li>
		    <li>评价</li>
		  </ul>
		  <div class="layui-tab-content">
		    <div class="layui-tab-item layui-show"></div>
		    <div class="layui-tab-item"></div>
		  </div>
		</div>
	</div>
	
	<%-- 底部 --%>
	<jsp:include page="footer.jsp"></jsp:include>
	
	<%-- 加载js --%>
	<script src="others/jquery.min.js"></script>
<!-- 	<script src="others/bootstrap/bootstrap.min.js"></script> -->
	<script src="others/layui/layui.js"></script>
	<script src="js/utils.js"></script>
	<script src="js/details.js"></script>
	
	<div style="display: none;" id="myData">
		<c:forEach items="${requestScope.list }" var="d">
		<div>
			<%-- details基本值 --%>
			<div>
				<span>${d.SID }</span>
				<span>${d.CID }</span>
				<span>${d.SName }</span>
				<span>${d.seriesSummary }</span>
				<span>${d.price }</span>
				<span>${d.stock }</span>
				<span>${d.color }</span>
				<span>${d.specification }</span>
			</div>
			<%-- model值 --%>
			<div>
				<span>${d.model.MID }</span>
				<span>${d.model.SID }</span>
				<span>${d.model.size }</span>
				<span>${d.model.resolution }</span>
				<span>${d.model.OS }</span>
				<span>${d.model.RAM }</span>
				<span>${d.model.ROM }</span>
				<span>${d.model.frontCamera }</span>
				<span>${d.model.rearCamera }</span>
				<span>${d.model.battery }</span>
				<span>${d.model.SOC }</span>
				<span>${d.model.thickness }</span>
				<span>${d.model.SIMType }</span>
				<span>${d.model.details }</span>
			</div>
			<%-- 图片list地址 --%>
			<div>
				<c:forEach items="${d.comPicture }" var="p">
				<span>${p }</span>
				</c:forEach>
			</div>
			<%-- 评价list地址 --%>
			<div>
				<c:forEach items="${d.evaluations }" var="e">
				<div>
					<span>${e.publishDate }</span>
					<span>${e.evaDetails }</span>
				</div>
				</c:forEach>
			</div>
		</div>
		</c:forEach>
	</div>
	
</body>
</html>