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

<style type="text/css">
	.sptp-img{
		border: 1px solid #dedede;
		padding: 5px;
		border-radius: 4px;
		display: inline-block;
		margin: 4px 2px;
		width: 195px;
	}
	.sptp-img div{
		height: 195px;
		margin-bottom: 10px;
		background-size: cover;
		-o-background-size: cover;
		-ms-background-size: cover;
		-moz-background-size: cover;
		-webkit-background-size: cover;
		background-repeat: no-repeat;
		background-position: center 50%;
	}
	.sptp-img button{
		width: 100%;
	}
</style>

</head>
<body style="overflow-y: scroll;">
	
	<div style="padding: 15px 10px 0px 10px;">
		<form class="layui-form" action="BackCommodityUpdateImg" method="post" enctype="multipart/form-data">
			<input type="hidden" name="CID" value="${requestScope.CID }" />
	        <button class="layui-btn" type="button" onclick="$('#addfile').click();">上传图片</button>
        	<%-- 上传文件隐藏区域 --%>
        	<div style="display: inline-block;">
	        	<input type="file" id="addfile" style="display: none;" accept="image/*" />
        	</div>
	        <button class="layui-btn" type="button" id="save1" style="float: right;">保存</button>
	        <span class="clear"></span>
        	<div style="border-bottom: 1px dashed #dedede;margin: 10px 0;"></div>
        	<div id="sptp-img-f" style="margin-bottom: 50px;">
        		<c:forEach items="${requestScope.list }" var="c">
        		<div class="sptp-img">
        			<div style="background-image: url('../${c.path}');"></div>
        			<button type="button" class="layui-btn layui-btn-normal" id="${c.CPID }">删除</button>
        		</div>
        		</c:forEach>
        	</div>
        	<div style="display: none;" id="sptp-img-del"></div>
        	<button style="display: none;" lay-submit lay-filter="submit" id="save2"></button>
		</form>
	</div>
	
	<%-- 加载js --%>
	<script src="../others/jquery.min.js"></script>
<!-- 	<script src="../others/bootstrap/bootstrap.min.js"></script> -->
	<script src="../others/layui/layui.js"></script>
	<script src="../js/back-utils.js"></script>
	
	<script type="text/javascript">
	$(document).ready(function(){
		layui.use(['form','layer'], function(){
			var form = layui.form;
			var layer = layui.layer;
			$('#save1').click(function(){
				if($('.sptp-img').length < 1){
					layer.msg('至少添加一张图片');
				}else{
					$('#save2').click();
				}
			});
			function delImg(dom){
				var val = Number(dom.attr('id'));
				if(val > 0){
					var content = '<input type="text" name="imgDelId" value="'+val+'" />';
					$(content).appendTo('#sptp-img-del');
				}
				// 删除原图片
				dom.parent().remove();
			}
			$('.sptp-img>button').click(function(){
				delImg($(this));
			});
			changeImg();
			function changeImg(){
				$('#addfile').change(function(){
					var file = $(this)[0].files[0];
					if(file != null){
						if(checkImgType(file.type)){
							var f = $(this).clone();
							f.attr('id','');
							f.attr('name','file');
							var content = 
								'<div class="sptp-img">'+
				        			'<div style=""></div>'+
				        			'<button type="button" class="layui-btn layui-btn-normal" id="0">删除</button>'+
				        		'</div>';
							$(content).appendTo('#sptp-img-f');
							var reader = new FileReader();
							reader.readAsDataURL(f[0].files[0]);
							reader.onload = function (e) {
								url = this.result;
								$('.sptp-img:last>div').css({
									'background-image':'url("'+url+'")'
								});
							}
							f.appendTo('.sptp-img:last');
							$('.sptp-img:last>button').click(function(){
								delImg($(this));
							});
							// 重新编译,作用在于清空file
							var html = $('#addfile').parent().html();
							$('#addfile').parent().html(html);
							changeImg();
						}
					}
				});
			}
		});
	});
	</script>
</body>
</html>