<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.cn.hysec.entity.Menu"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
		<meta charset="utf-8">
		<title>Hello MUI</title>
		<meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1,user-scalable=no">
		<meta name="apple-mobile-web-app-capable" content="yes">
		<meta name="apple-mobile-web-app-status-bar-style" content="black">

		<!--标准mui.css-->
		<link rel="stylesheet" href="../css/mui.min.css">
		<!--App自定义的css-->
		<link rel="stylesheet" type="text/css" href="../css/app.css"/>

  </head>
  
  <body>
    <header class="mui-bar mui-bar-nav">
		    <!--a class="mui-action-back mui-icon mui-icon-left-nav mui-pull-left"></a-->
		    <h1 class="mui-title">首页</h1>
	</header>
    <div class="mui-content">
       <ul class="mui-table-view mui-grid-view mui-grid-9">
  <%List<Menu> menuList=(List<Menu>)request.getAttribute("menu");
  	for(int i=0;i<menuList.size();i++){
  		Menu menu =menuList.get(i);
  		%>
  		<li class="mui-table-view-cell mui-media mui-col-xs-4 mui-col-sm-3">
  			<a href="/xxzx/menu/pagechange.do?id=<%=menu.getMenuId()%>">
		<span class="mui-icon mui-icon-home"></span>
		<div class="mui-media-body"><%=menu.getMenuName()%></div></a></li>
  		<%
  	}
  %>
  		</ul> 
  	  </div>
        <!--header class="mui-bar mui-bar-nav">
		    <a class="mui-action-back mui-icon mui-icon-left-nav mui-pull-left"></a>
		    <h1 class="mui-title">9宫格默认样式</h1>
		</header-->
  </body>
  <script src="../js/mui.min.js"></script>
	<script>
		mui.init({
			swipeBack:true //启用右滑关闭功能
		});
	</script>
</html>
