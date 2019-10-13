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
			var UID = data.UID;
			if(layEvent == "edit"){
				layer.open({
					type: 2,
					title: '修改用户信息',
					resize: false,
					move: false,
					shadeClose: true,
					area: ['320px','310px'],
					content: 'BackUserOne?UID='+UID,
					end: function(){
						$('#selectButton').click();
					},
				});
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
							var content = "<input type='hidden' value='"+d[i].UID+"' name='UID' />";
							$(content).appendTo('#batchSelect');
						}
						$('#batchSelect button[type="submit"]').click();
					}
				}
			});
		});
	});
});
