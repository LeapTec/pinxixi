<%@page import="com.pinxixi.dao.BrandDao"%>
<%@page import="com.pinxixi.vo.Brand"%>
<%@page import="com.pinxixi.vo.page.Search"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>

<%-- 基本模型 --%>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="renderer" content="webkit">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- <link href="others/bootstrap/bootstrap.min.css" rel="stylesheet"> -->
<link href="others/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet">
<link href="others/layui/css/layui.css" rel="stylesheet">
<link href="css/utils.css" rel="stylesheet">
<title>拼夕夕 - 搜索</title>

<%-- ico引入 --%>
<link rel="Shortcut Icon" href="img/icon.ico" />
<link rel="icon" href="img/icon.ico" />

<%-- 引入页面所需css --%>
<link href="css/search.css" rel="stylesheet">

</head>
<body>
    <%--获得所有品牌 --%>
    <%
    BrandDao brandDao=new BrandDao();
    List<Brand> listBrand=(List<Brand>)brandDao.SelectBrandAll("");
    String a=(String)request.getAttribute("conditions");
    int b=(int)request.getAttribute("SorType");
    int c=(int)request.getAttribute("Sort");
    int e=(int)request.getAttribute("BID");
    %>
     
	<%-- 导航栏 --%>
	<jsp:include page="nav.jsp"></jsp:include>
	
	<%-- 内容部分 --%>
	<div id="search-form">
		<form action="PageSearch" method="post">
			<div>
				<div>全部结果&nbsp;>&nbsp;</div>
				<div>
					<div>
						<input type="text" name="conditions" <%if(request.getAttribute("conditions")!=null){
							%> value="<%=request.getAttribute("conditions") %>"
						<% } %> placeholder="搜索" />
						<button id="button"><i class="fa fa-search"></i></button>
						<span class="clear"></span>
					</div>
				</div>
				<span class="clear"></span>
			</div>
			<div>
				<div>品牌：</div>
				<input type="hidden" name="BID" id="BID" <%
				if((int)request.getAttribute("BID")>=1){
					%>
					value=<%=request.getAttribute("BID") %>
					<%
				}else{
					%>value=""<%
				}
				%>>
				<div style="height: 39px;" id="search-height">
					<%for(int i=0;i<listBrand.size();i++) {%>
					<div><a href="javascript:;"
					<%if(listBrand.get(i).getBID()==(int)request.getAttribute("BID")){ %>
						class="active"
					<% } %>  
					onclick="$('#BID').val(<%=listBrand.get(i).getBID() %>);$('#button').click();"><%=listBrand.get(i).getBName() %></a></div>
					<%} %>
					<span class="clear"></span>
				</div>
				<div>
					<a href="javascript:;" id="search-more">更多</a>
				</div>
				<span class="clear"></span>
			</div>
			<div>
			    <input type="hidden" name="SorType" id="SorType" value="">
			    <input type="hidden" name="Sort" id="Sort" value="">
				<div>
					<a href="javascript:;" onclick="$('#SorType').val(0);$('#Sort').val(1);$('#button').click();"
					<%if((int)request.getAttribute("SorType")==0&&(int)request.getAttribute("Sort")==1){%>
						class="active"
						<% } %>
					>最新</a>
				</div>
				<div>
					<a href="javascript:;" onclick="$('#SorType').val(1);$('#Sort').val(0);$('#button').click();"
						<%if((int)request.getAttribute("SorType")==1&&(int)request.getAttribute("Sort")==0){%>
						class="active"
						<% } %>
					>价格</a>
				</div>
				<span class="clear"></span>
			</div>
<%-- 			<%--  --%>
            <%
            List<Search> list =(List<Search>) request.getAttribute("Searchlist");
              if(list.size()>=1){ %>
            	  <div id="search-flag">
				<div>
					<%for(int i=0;i<list.size();i++){ %>
					<div class="search-flag-item" id="<%=list.get(i).getSID()%>" >
						<div style="background-image: url('<%=list.get(i).getPath() %>');"></div>
						<div><%=list.get(i).getSName() %></div>
						<div><%=list.get(i).getSummary() %></div>
						<div>
							<span>¥</span>
							<span><%=list.get(i).getLowestPrice() %></span>
						</div>
					</div>
					<%} %>
					<span class="clear"></span>
				</div>
			</div>
			<div id="search-page-block">
				<div id="search-page"></div>
			</div>
             <% }else{ %>
            	 <div id="search-null">没有找到相关商品</div>
            <% }%>
		</form>
	</div>
	
	<%-- 底部 --%>
	<jsp:include page="footer.jsp"></jsp:include>
	
	<%-- 加载js --%>
	<script src="others/jquery.min.js"></script>
<!-- 	<script src="others/bootstrap/bootstrap.min.js"></script> -->
	<script src="others/layui/layui.js"></script>
	<script src="js/utils.js"></script>
	<script src="js/search.js"></script>
	
</body>
</html>