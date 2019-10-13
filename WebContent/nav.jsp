<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<nav>
	<div>
		<div><a href="Index"></a></div>
		<div>
			<div id="user">
<!-- 				<a href="javascript:;" id="login">登录</a> -->
<!-- 				&nbsp;/&nbsp; -->
<!-- 				<a href="javascript:;" id="register">注册</a> -->
               <%
               System.out.println(session.getAttribute("LoginName"));
               if(session.getAttribute("LoginName")==null){
            	   %>
            	   <a href="javascript:;" id="login">登录</a>
				&nbsp;/&nbsp;
				<a href="javascript:;" id="register">注册</a>
				<%
            	   }else{
            		   %>
            		   <div>
					<i class="fa fa-user"></i>
					<div>
						<a href="javascript:;" id="msg">个人信息</a>
						<a href="javascript:;" id="uppass">修改密码</a>
						<a href="javascript:;" id="address">地址管理</a>
						<a href="javascript:;" id="myorders">我的订单</a>
						<a href="javascript:;" id="logout">退出</a>
					</div>
				</div>
            		   <%
            	   }%>
			</div>
			<div id="car"><a href="PageCar">
				<i class="fa fa-shopping-cart"></i>
			</a></div>
			<div id="search">
				<form action="PageIndexToSearch" method="post">
					<div>
						<input type="text" name="conditions" placeholder="搜索" />
						<button><i class="fa fa-search"></i></button>
						<span class="clear"></span>
					</div>
				</form>
			</div>
			<span class="clear"></span>
		</div>
		<span class="clear"></span>
	</div>
</nav>