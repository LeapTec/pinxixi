$(document).ready(function(){
	layui.use(['layer','util'], function(){
		var layer = layui.layer;
		var util = layui.util;
		util.fixbar({});
		$('#msg').click(function(){
			layer.open({
				type: 2,
				title: '个人信息',
				resize: false,
				move: false,
				shadeClose: true,
				area: ['320px','325px'],
				content: 'UsersInfo',
			});
		});
		$('#uppass').click(function(){
			layer.open({
				type: 2,
				title: '修改密码',
				resize: false,
				move: false,
				shadeClose: true,
				area: ['320px','270px'],
				content: 'uppass.jsp',
			});
		});
		$('#logout').click(function(){
			var layerOpen = layer.open({
				content : "确认退出登录吗？",
				title : "退出",
				btn : [ '确定', '取消' ],
//				skin: 'check-box-class',
				resize: false,
				shadeClose: true,
				yes : function(index, layero) {
					layer.close(layerOpen);
					// 发送请求,删除session
					window.top.location.href="LogOut";
				}
			});
		});
		$('#login').click(function(){
			layer.open({
				type: 2,
				title: '登录',
				resize: false,
				move: false,
				shadeClose: true,
				area: ['320px','230px'],
				content: 'login.jsp',
			});
		});
		$('#register').click(function(){
			layer.open({
				type: 2,
				title: '注册',
				resize: false,
				move: false,
				shadeClose: true,
				area: ['320px','380px'],
				content: 'register.jsp',
			});
		});
		$('#address').click(function(){
			layer.open({
				type: 2,
				title: '地址管理',
				resize: false,
				move: false,
				shadeClose: true,
				area: ['490px','80%'],
				content: 'AddressAll',
			});
		});
		$('#myorders').click(function(){
				window.top.location.href="MyOrders";
		});
	});
});
