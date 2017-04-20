<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<title>Hello MUI</title>
	<meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1,user-scalable=no">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<link href="../css/style.css" rel="stylesheet" />
	<!--标准mui.css-->
	<link rel="stylesheet" href="../css/mui.min.css">
	<!--App自定义的css-->
	<link rel="stylesheet" type="text/css" href="../css/app.css"/>
	<style>
		.r{position:fixed; bottom:-1;width:100%;text-align:center}
	</style>
  </head>
  
  <body>
    <header class="mui-bar mui-bar-nav">
		<a class="mui-action-back mui-icon mui-icon-left-nav mui-pull-left" h></a>
		<h1 class="mui-title" >登记列表</h1>
	</header>
	<div class="mui-content">
    <form class="mui-input-group" id="list">
        <div>
    	<ul class="mui-table-view">
        <%
    	  ArrayList<String[]> oList= new ArrayList<String[]>();
    	  oList=(ArrayList<String[]>)request.getAttribute("map");
  			for(int i=0;i<oList.size();i++){
  		%>  <!--div class="mui-input-row"><label><h6>
			</h6></label><div class="mui-numbox"-->
			<li class="mui-table-view-cell"><%=oList.get(i)[1] %><span class="mui-badge mui-badge-primary"><input type="hidden" class="aaa" id="<%=oList.get(i)[0] %>" value="<%=oList.get(i)[2] %>"/><%=oList.get(i)[2] %></span></li>
		    <!--/div></div-->
  		<%} %>
    	</ul>
      </div>
      <%=path %>
    </form>
    <form  id = "listform">
    	<input type='hidden' id='map' name='map'>
    	<input type='hidden' id='lis' name='lis'>
      <div class="r">
        <input type="submit" value="确认添加" width="100%" id="toastBtn"  class="btn btn-primary" onclick="return false;"/>
      </div>
    </form>
  </body>
    <script src="../js/mui.enterfocus.js"></script>
	<script src="../js/app.js"></script>
    <script src="../js/mui.min.js"></script>
    <script src="../js/mui.js"></script>
    <script type="text/javascript" src="../js/jquery.min.js"></script>
    <script>
		mui.init({
			swipeBack:true //启用右滑关闭功能
		});
		document.getElementById("toastBtn").addEventListener('tap', function() {
			var inp=document.getElementsByClassName("aaa");
			var map={};
			var lis=[];
			var j=0;
			for(var i=0;i<inp.length;i++){
				var a=inp[i].id;
				map[a]=inp[i].value;
				var b = inp[i].value;
				lis[j]=a;
				j++;
			}
			//document.getElementById("map").value = JSON.stringify(map);
			//document.getElementById("lis").value = lis;
			alert(lis);
			map =  JSON.stringify(map); 
			alert(map);
			//alert(j);
			if(j<=0){
				mui.toast('没有选择办公用品！');
			}else{
				$.ajax({
				type: "POST",
				url: '/xxzx/officeSupplies/officetj.do',
			    data: {map:map,list:lis},
				dataType:'json',
				cache: false,
				success: function(data){
					if(data.code == 0){ 
						mui.toast("提交成功！");
						/* $.openWindow({
							url: '/xxzx/menu/showMenu.do?id='+data.msg,
										id: 'main',
										preload: true,
										show: {
											aniShow: 'pop-in'
										},
										styles: {
											popGesture: 'hide'
										},
										waiting: {
											autoShow: false
										}
									});
								 */
					} else if(data.code == 1){
						mui.alert(data.msg, 'Hello MUI');
					}
				},
				error:function(data){
					mobile_alert(2);
				}
			});
		}
	});
	</script>
</html>
