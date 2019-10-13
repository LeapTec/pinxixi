$(document).ready(function(){
	layui.use(['form','table','layer'], function(){
		var form = layui.form;
		var table = layui.table;
		var layer = layui.layer;
		table.init('table', {
			id : 'table',
			page : true,
			loading : true,
			text : {
				none: '暂无相关数据'
			},
		});
		table.on('tool(table)',function(obj){
			var data = obj.data;
			var layEvent = obj.event;
			if(layEvent == "edit"){
				if(data.Status == '未发货'){
					layer.open({
						type: 2,
						title: '填写快递单号',
						resize: false,
						move: false,
						shadeClose: true,
						area: ['320px','160px'],
						content: 'fh.jsp?OID='+data.OID,
					});
				}else if(data.Status == '未支付'){
					layer.msg('用户未支付,请勿发货');
				}else if(data.Status == '已发货'){
					layer.msg('该订单已发货,请勿重复发货');
				}else if(data.Status == '已签收'){
					layer.msg('该订单已被签收,请勿重复发货');
				}else if(data.Status == '已取消'){
					layer.msg('该订单已被取消');
				}else{
					layer.msg('该订单正在进行退货操作,请审核退货');
				}
			}else{
				if(data.Status == '已取消'){
					layer.msg('该订单已取消');
				}else if(data.Status.indexOf('退货中') < 0){
					layer.msg('该订单未做退货操作');
				}else{
					var layerOpen = layer.open({
						content : "审核该订单是否可退货",
						title : "审核退货",
						btn : [ '通过', '不通过', '取消' ],
						resize: false,
						shadeClose: true,
						yes : function(index, layero) {
							layer.close(layerOpen);
							window.location.href='BackOrdersCancelCheck?OID='+data.OID+'&&check=1';
						},
						btn2 : function(index, layero) {
							layer.close(layerOpen);
							window.location.href='BackOrdersCancelCheck?OID='+data.OID+'&&check=0';
						},
					});
				}
			}
		});
		form.on('submit(executeList)', function(dt){
			var layerOpen = layer.open({
				content : "确认删除吗？",
				title : "批量删除",
				btn : [ '确定', '取消' ],
				resize: false,
				shadeClose: true,
				yes : function(index, layero) {
					layer.close(layerOpen);
					var action = dt.field.batchSelect;
					if(action == "del"){
						var d = table.checkStatus('table').data;
						for(var i=0;i<d.length;i++){
							var content = "<input type='hidden' value='"+d[i].OID+"' name='OID' />";
							$(content).appendTo('#batchSelect');
						}
						$('#batchSelect button[type="submit"]').click();
					}
				}
			});
		});
	});
});
