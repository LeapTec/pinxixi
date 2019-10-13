$(document).ready(function(){
	layui.use(['carousel','form','element'], function(){
		var carousel = layui.carousel;
		var form = layui.form;
		var element = layui.element;
		var options = {
			elem: '#details-banner',
			width: '100%',
			indicator: 'none',
		};
		var ins = carousel.render(options);
		setImgHeight();
		function setImgHeight(){
			$('#details-buy-left>div>div').css('height',$('#details-buy-left>div>div').width());
		}
		$(window).resize(function() {
			setImgHeight();
		});
		// 刚进入时拿第一个值
		var oneColor = $('#myData>div:nth-of-type(1)>div:nth-of-type(1)>span:nth-of-type(7)').html();
		var oneSpec = $('#myData>div:nth-of-type(1)>div:nth-of-type(2)>span:nth-of-type(6)').html() + "+";
		oneSpec += ($('#myData>div:nth-of-type(1)>div:nth-of-type(2)>span:nth-of-type(7)').html() + "GB");
		getMydata(oneColor,oneSpec);
		form.on('select(color)', function(data){
			getMydata(data.value,$('select[name="spe"]').val());
		});
		form.on('select(spe)', function(data){
			getMydata($('select[name="color"]').val(),data.value);
		});
		function getMydata(color,spec){
			$('#myData>div').each(function(){
				if($(this).find('div:nth-of-type(1)>span:nth-of-type(7)').html() == color){
					var specification = $(this).find('div:nth-of-type(2)>span:nth-of-type(6)').html() + "+";
					specification += ($(this).find('div:nth-of-type(2)>span:nth-of-type(7)').html() + "GB");
					if(specification == spec){
						var div1 = $(this).find('div:nth-of-type(1)');
						var div2 = $(this).find('div:nth-of-type(2)');
						var div3 = $(this).find('div:nth-of-type(3)');
						var div4 = $(this).find('div:nth-of-type(4)');
						// 设置标题
						$('#details-title').html(div1.find('span:nth-of-type(3)').html());
						$('#details-buy-right form>div:nth-of-type(1)').html(div1.find('span:nth-of-type(3)').html());
						// 设置轮播图
						var banner = '';
						div3.find('span').each(function(){
							banner += ('<div style="background-image: url(\''+$(this).html()+'\');"></div>');
						});
						$('#details-banner>div').html(banner);
						ins.reload(options);
						setImgHeight();
						// 设置那行字
						$('#details-buy-right form>div:nth-of-type(2)').html(div1.find('span:nth-of-type(4)').html());
						// 设置价格
						$('#details-buy-right form>div:nth-of-type(3)>div:nth-of-type(1)>span:nth-of-type(2)').html(
								div1.find('span:nth-of-type(5)').html()
						);
						// 设置一堆参数
						var model = '';
						model += ('<span>尺寸 '+div2.find('span:nth-of-type(3)').html()+'</span>');
						model += ('<span>分辨率 '+div2.find('span:nth-of-type(4)').html()+'</span>');
						model += ('<span>'+div2.find('span:nth-of-type(5)').html()+'系统</span>');
						model += ('<span>前置 '+div2.find('span:nth-of-type(8)').html()+' （万）像素</span>');
						model += ('<span>后置 '+div2.find('span:nth-of-type(9)').html()+' （万）像素</span>');
						model += ('<span>电池 '+div2.find('span:nth-of-type(10)').html()+' mAh</span>');
						model += ('<span>处理器 '+div2.find('span:nth-of-type(11)').html()+'</span>');
						model += ('<span>厚度 '+div2.find('span:nth-of-type(12)').html()+' mm</span>');
						model += ('<span>'+div2.find('span:nth-of-type(13)').html()+'</span>');
						$('#details-buy-right form>div:nth-of-type(3)>div:nth-of-type(2)').html(model);
						// 设置库存
						$('#details-buy-right form>div:nth-of-type(5)>div:nth-of-type(1)>div').html(
								div1.find('span:nth-of-type(6)').html()
						);
						// 把所有颜色分类弄出来
						var colors = new Array();
						var colorContext = '';
						$('#myData>div').each(function(){
							var colorContextMsg = $(this).find('div:nth-of-type(1)>span:nth-of-type(7)').html();
							var flag = true;
							for(var i=0;i<colors.length;i++){
								if(colorContextMsg == colors[i]){
									flag = false;
									break;
								}
							}
							if(flag){
								colors.push(colorContextMsg);
								colorContext += ('<option value="'+colorContextMsg+'">'+colorContextMsg+'</option>');
							}
						});
						$('#details-buy-right form select[name="color"]').html(colorContext);
						// 选中颜色
						$('#details-buy-right form select[name="color"]').val(color);
						// 把该颜色所有的规格弄出来
						var specs = new Array();
						var specContext = '';
						$('#myData>div').each(function(){
							if($(this).find('div:nth-of-type(1)>span:nth-of-type(7)').html() == color){
								var specContextMsg = $(this).find('div:nth-of-type(2)>span:nth-of-type(6)').html() + "+";
								specContextMsg += ($(this).find('div:nth-of-type(2)>span:nth-of-type(7)').html() + "GB");
								var flag = true;
								for(var i=0;i<specs.length;i++){
									if(specContextMsg == specs[i]){
										flag = false;
										break;
									}
								}
								if(flag){
									specs.push(specContextMsg);
									specContext += ('<option value="'+specContextMsg+'">'+specContextMsg+'</option>');
								}
							}
						});
						$('#details-buy-right form select[name="spe"]').html(specContext);
						// 选中规格
						$('#details-buy-right form select[name="spe"]').val(spec);
						form.render("select");
						// 设置详情
						$('#details-tabs>div>div>div:nth-of-type(1)').html(div2.find('span:nth-of-type(14)').html());
						// 设置评论
						var plContext = '';
						div4.find('div').each(function(){
							plContext += (
								'<div><div>'+
								$(this).find('span:nth-of-type(2)').html()+
								'</div><div>'+
								$(this).find('span:nth-of-type(1)').html()+
								'</div></div>'
							);
						});
						$('#details-tabs>div>div>div:nth-of-type(2)').html(plContext);
						// 设置CID
						$('#buttonTo>input[name="CID"]').val(div1.find('span:nth-of-type(2)').html());
						// 设置SID
						$('#buttonTo>input[name="SID"]').val(div1.find('span:nth-of-type(1)').html());
					}
				}
			});
		}
		$('#tobuy').click(function(){
			var kucun = Number($('#details-buy-right form>div:nth-of-type(5)>div:nth-of-type(1)>div').html());
			if(kucun >= Number($('#buyNumber').val())){
				var val = $('#buttonTo>input[name="CID"]').val() + "-" + $('#buyNumber').val();
				$('#buttonTo>input[name="CIDNUM"]').val(val);
				$('#details-buy-right form').attr('action','OrderEnter');
				$('#details-buy-button').click();
			}else{
				layer.msg('库存不足');
			}
		});
		$('#tocar').click(function(){
			$('#details-buy-right form').attr('action','ShoppingCarAdd');
			$('#details-buy-button').click();
		});
	});
});
