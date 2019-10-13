$(document).ready(function(){
	layui.use(['form','layer'], function(){
		var form = layui.form;
		var layer = layui.layer;
		$('.topj').click(function(){
			var id = $(this).attr('id');
			layer.open({
				type: 2,
				title: '评价',
				resize: false,
				move: false,
				shadeClose: true,
				area: ['320px','160px'],
				content: 'pj.jsp?OID='+id,
			});
		});
		$('.toqr').click(function(){
			var id = $(this).attr('id');
			var layerOpen = layer.open({
				content : "确认收货吗？",
				title : "确认收货",
				btn : [ '确定', '取消' ],
				resize: false,
				shadeClose: true,
				yes : function(index, layero) {
					layer.close(layerOpen);
					window.location.href='MyOrdersEnter?OID='+id;
				}
			});
		});
		$('.toth').click(function(){
			var id = $(this).attr('id');
			var layerOpen = layer.open({
				content : "确认退货吗？",
				title : "退货",
				btn : [ '确定', '取消' ],
				resize: false,
				shadeClose: true,
				yes : function(index, layero) {
					layer.close(layerOpen);
					window.location.href='MyOrdersCancel?OID='+id;
				}
			});
		});
		$('.toqt').click(function(){
			var id = $(this).attr('id');
			var layerOpen = layer.open({
				content : "确认取消退货吗？",
				title : "取消退货",
				btn : [ '确定', '取消' ],
				resize: false,
				shadeClose: true,
				yes : function(index, layero) {
					layer.close(layerOpen);
					window.location.href='MyOrdersCancelCancel?OID='+id;
				}
			});
		});
	});
});
