$(document).ready(function(){
	layui.use(['laypage'], function(){
		var laypage = layui.laypage;
		$('#search-more').hide();
		setMore();
		function setMore(){
			var width = $('#search-height').width();
			var allWidth = 0;
			$('#search-height>div').each(function(i){
				allWidth += ($(this).width() + 20);
				if(allWidth > width){
					$('#search-more').show();
					return;
				}
				$('#search-more').hide();
			});
		}
		setFlag();
		function setFlag(){
			var width = $('#search-flag').width();
			var number = parseInt(width / 312);
			var padding = (width - number * 312) / 2;
			$('#search-flag>div').css('padding-left',padding);
		}
		$(window).resize(function() {
			setMore();
			setFlag();
		});
		$('#search-more').click(function(){
			if($('#search-height').css('height') == '39px'){
				$('#search-height').css('height','auto');
			}else{
				$('#search-height').css('height','39px');
			}
		});
		$('.search-flag-item').click(function(){
			var id = $(this).attr('id');
			window.location.href = 'PageDetails?id='+id;
		});
		var pageCount = 50;
		var pageCurr = 1;
		laypage.render({
			elem: 'search-page',
			count: pageCount,
			curr: pageCurr,
			theme: '#ff3f4b',
			jump: function(obj,first){
				console.log(obj.curr);
				if(!first){
//					console.log(1);
			    }
			},
		});
	});
});
