$(document).ready(function(){
	layui.use(['form'], function(){
		var form = layui.form;
		$("#addressClick>div").click(function(){
			$("#addressClick>div.click").removeClass('click');
			$(this).addClass('click')
			$('input[name="AID"]').val($(this).attr('id'));
		});
	});
});
