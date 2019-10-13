<%@page import="com.pinxixi.utils.PageAction"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.pinxixi.vo.Adviertisement"%>
<%@page import="java.util.List"%>
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
<title>拼夕夕后台 - 广告管理</title>

<%-- ico引入 --%>
<link rel="Shortcut Icon" href="../img/icon.ico" />
<link rel="icon" href="../img/icon.ico" />

<%-- 引入页面所需css --%>
<link href="../css/back-ad.css" rel="stylesheet">

</head>
<body class="layui-layout-body">
	<div class="layui-layout layui-layout-admin">
		<%-- 头部 --%>
		<jsp:include page="head.jsp"></jsp:include>

		<%-- 左侧导航栏 --%>
		<jsp:include page="nav.jsp"></jsp:include>
		
		<%-- 主体内容区域 --%>
		<div class="layui-body">
			<fieldset class="layui-elem-field layui-field-title">
				<legend>广告管理</legend>
			</fieldset>
			<div class="layui-row layui-col-space15">
				<div class="layui-col-xs12">
					<%
					List<Adviertisement> list = new ArrayList<Adviertisement>();
					if(request.getAttribute("list") != null){
						list = (List<Adviertisement>)request.getAttribute("list");
						if(list == null || list.size() < 1){
							list = new ArrayList<Adviertisement>();
						}
					}
					%>
					<%String[] sx = {"A","B","C","D"}; %>
					<%for(int i=0;i<4;i++){ Adviertisement ad = PageAction.getAdviertisement(list, sx[i]);%>
					<form class="layui-form" action="BackADUpdate" method="post" enctype="multipart/form-data">
						<div class="layui-col-xs6">
							<div class="ad-padding">
								<div class="ad-block">
									<input type="hidden" name="ADID" value="<%=ad.getADID() %>" />
									<input type="hidden" name="Grade" value="<%=sx[i] %>" />
				        			<div class="ad-img" style="background-image: url('../<%=ad.getPath() %>');"></div>
				        			<input type="text" name="ADDetails" value="<%=ad.getADDetails() %>" required lay-verify="required"
						      		 placeholder="请填写广告详情" autocomplete="off" class="layui-input" style="margin-top: 10px;">
				        			<button class="layui-btn" type="button" onclick="$('#addfile<%=i+1 %>').click();">上传图片</button>
						        	<%-- 上传文件隐藏区域 --%>
						        	<div>
										<%-- 下面这个div是用来放原本的图片的地址 --%>
										<div class="ad-img-address" style="display: none;">../<%=ad.getPath() %></div>
							        	<input type="file" id="addfile<%=i+1 %>" name="file<%=i %>" style="display: none;" accept="image/*" />
							        	<input type="hidden" name="Path" value="<%=ad.getPath() %>" />
						        	</div>
				        			<button class="layui-btn layui-btn-normal">保存</button>
				        			<span class="clear"></span>
				        		</div>
							</div>
						</div>
					</form>
					<%} %>
				</div>
			</div>
		</div>
	</div>
	
	<%-- 加载js --%>
	<script src="../others/jquery.min.js"></script>
<!-- 	<script src="../others/bootstrap/bootstrap.min.js"></script> -->
	<script src="../others/layui/layui.js"></script>
	<script src="../js/back-utils.js"></script>
	<script src="../js/back-ad.js"></script>
	
	<script type="text/javascript">
	$(document).ready(function(){
		layui.use(['form'], function(){
			var form = layui.form;
			$('input[type="file"]').change(function(){
				var file = $(this)[0].files[0];
				if(file != null){
					if(checkImgType(file.type)){
						browseImg($(this), '');
					}else{
						browseImg($(this), 'default');
					}
				}else{
					browseImg($(this), 'default');
				}
			});
			function browseImg(dom, url){
				if(url != 'default'){
					var file = dom[0].files[0];
					var reader = new FileReader();
					reader.readAsDataURL(file);
					reader.onload = function (e) {
						url = this.result;
						$(dom.parents('form').find('.ad-img')).css({
							'background-image':'url("'+url+'")'
						});
					}
				}else{
					var def = $(dom.parents('form').find('.ad-img-address')).html();
					if(def != null && def != ''){
						$(dom.parents('form').find('.ad-img')).css({
							'background-image': 'url("'+def+'")'
						});
					}else{
						$(dom.parents('form').find('.ad-img')).attr('style','');
					}
				}
			}
		});
	});
	</script>
	
</body>
</html>