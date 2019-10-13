$(document).ready(function(){
	layui.use(['form','table','layer'], function(){
		var form = layui.form;
		var table = layui.table;
		var layer = layui.layer;
		table.init('table', {
			id:"table",
			limit : 10,
			page : true,
			loading : true,
			text : {
				none: '暂无相关数据'
			},
		});
		$('#del').click(function (){	
			var layerOpen = layer.open({
				content : "确认删除吗？",
				title : "批量删除",
				btn : [ '确定', '取消' ],
				resize: false,
				shadeClose: true,
				yes : function(index, layero) {
					layer.close(layerOpen);
					var d = table.checkStatus('table').data;
					for(var i=0;i<d.length;i++){
						var content = "<input type='hidden' value='"+d[i].UID+","+d[i].CID+"' name='UCID' />";
						$(content).appendTo('#batchSelect');
					}
					$('#batchSelect button').click();
				}
			});
		});
		table.on('checkbox(table)', function(obj){
			var checkStatus = table.checkStatus('table');
			$('#cars-tobuy>div:nth-of-type(1)>div>span:nth-of-type(2)').html(checkStatus.data.length);
			// 修改合计
			var sum = 0;
			var d = checkStatus.data;
			for(var i=0;i<d.length;i++){
				var sumStr = d[i].sum.split(' ')[1];
				sum += Number(sumStr);
			}
			sum = new Number(sum).toFixed(2);
			$('#heji').html(sum);
			// 添加input
			var input = '';
			for(var i=0;i<d.length;i++){
				input += ('<input type="hidden" name="CIDNUM" value="'+d[i].CID + "-" + d[i].number+'" />');
			}
			$('#CN').html(input);
		});
		$('#gotobuy').click(function(){
			if(table.checkStatus('table').data.length > 0){
				$('#gotobuy2').click();
			}else{
				layer.msg('请勾选需要结算的商品');
			}
		});
	});
});