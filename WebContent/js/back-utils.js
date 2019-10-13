$(document).ready(function(){
	layui.use(['element','layer','form','util'], function(){
		var element = layui.element;
		var layer = layui.layer;
		var form = layui.form;
		var util = layui.util;
		util.fixbar({});
		$('#logout').click(function(){
			var layerOpen = layer.open({
				content : "确认退出登录吗？",
				title : "退出",
				btn : [ '确定', '取消' ],
				resize: false,
				shadeClose: true,
				yes : function(index, layero) {
					layer.close(layerOpen);
					window.top.location.href="BackLogout";
				}
			});
		});
		$('#tj').click(function(){
			layer.open({
				type: 2,
				title: '统计销售额',
				resize: false,
				move: false,
				shadeClose: true,
				area: ['680px','380px'],
				content: 'BackSelectSale',
			});
		});
	});
});
function checkImgType(type){
	if(type.indexOf('image/') != -1){
		return true;
	}
	return false;
}
