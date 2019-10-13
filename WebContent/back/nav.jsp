<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<nav>
	<div class="layui-side layui-bg-black">
		<div class="layui-side-scroll">
			<ul class="layui-nav layui-nav-tree">
				<li class="layui-nav-item"><a href="BackOrders">订单管理</a></li>
				<li class="layui-nav-item"><a href="BackCommodity">商品管理</a></li>
				<li class="layui-nav-item">
					<a href="javascript:;">分类管理</a>
					<dl class="layui-nav-child">
						<dd>
							<a href="BackBrand">品牌</a>
						</dd>
						<dd>
							<a href="BackSeries">系列</a>
						</dd>
						<dd>
							<a href="BackModel">型号</a>
						</dd>
					</dl>
				</li>
				<li class="layui-nav-item"><a href="BackEvaluation">评论管理</a></li>
				<li class="layui-nav-item"><a href="javascript:;" id="tj">&nbsp;销&nbsp;售&nbsp;额</a></li>
				<li class="layui-nav-item"><a href="BackAD">广告管理</a></li>
				<li class="layui-nav-item"><a href="BackUser">用户管理</a></li>
				<li class="layui-nav-item"><a href="javascript:;" id="logout">退出</a></li>
			</ul>
		</div>
	</div>
</nav>