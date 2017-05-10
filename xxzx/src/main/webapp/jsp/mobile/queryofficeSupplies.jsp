<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<meta charset="utf-8">
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
		<a class="mui-action-back mui-icon mui-icon-left-nav mui-pull-left"></a>
		<h1 class="mui-title">办公用品查询</h1>
	</header>
	<div class="mui-content">
    <form class="mui-input-group" id="list">
    	<div></div>
    </form>
    <div>
    <form action="/xxzx/officeSupplies/officelist.do" method="post" id = "listform">
    	<input type='hidden' id='map' name='map'>
    	<input type='hidden' id='lis' name='lis'>
      <div class="r">
        <!-- 
        <input type="submit" value="返回" width="100%" id="toastBtn"  class="btn btn-primary" onclick="return false;"/>
        
         -->        
         <!--button type="button" width="100%" class="mui-btn mui-btn-primary mui-btn-block">Block button</button-->
      </div>
    </form>
</div>
    </div>
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
		$(document).ready(function(){
			$.ajax({
				type: "POST",
				url: '/xxzx/QueryofficeSupplies/query.do',
			    data: {},
				dataType:'json',
				cache: false,
				success: function(data){
				    //alert(data.data.length);
					//mui.alert(data.code, 'Hello MUI'); 
						var html_list="";
						if(data.code == 0){
							//alert(data.data[0][2], 'Hello MUI');
							
						  for(var i=0;i<data.data.length;i++){
							html_list= html_list+'<div class="mui-input-row"><label><h6>'+data.data[i][1]+
								      //'<div id="M_Toggle" class="mui-switch mui-active">'+
								      '</h6></label><div class="mui-numbox">'+
									  
									  '<input class="mui-input-numbox" type="number" value="'+data.data[i][2]+'" id="'+data.data[i][0]+'" />'+
									 
									  //'</div>'+
								      '</div></div>';
					       }
						   $("#list").find("div").append(html_list);
						} else if(data.code == 1){
							mui.alert(data.msg, 'Hello MUI');
						}
				},
				error:function(data){
					mobile_alert(2);
				}
			})
		})
		function zj(obj){
			var val=document.getElementById(obj.id.substring(2)).value;
			if(val>0){
				document.getElementById(obj.id.substring(2)).value = parseInt(val)-1;
			}else{
				document.getElementById(obj.id.substring(2)).value = 0;
			}
		}
		function add(obj){
			var val=document.getElementById(obj.id.substring(2)).value;
			document.getElementById(obj.id.substring(2)).value = parseInt(val)+1;
		}
		function tj(){
			var inp=document.getElementsByClassName("mui-input-numbox");
			var map={};
			var lis=[];
			var j=0;
			for(var i=0;i<inp.length;i++){
				//mui.alert(inp[i].id+":"+inp[i].value);
				//mui.alert(1, "111");
				if(inp[i].value>0){
					var a=inp[i].id;
					map[a]=inp[i].value;
					var b = inp[i].value;
					lis[j]={a,b};
					j++;
				} 
				//var len =lis.length;
				/* for(var i=0;i<len;i++){
					mui.alert(map[i], "tijiao");
				} */
				var x = lis.length+",,"
				
			}
			document.getElementById("map").value = JSON.stringify(map);
			document.getElementById("lis").value = lis;
			map =  JSON.stringify(map); 
			alert(j);
			if(j<=0){
			    alert(1);
				mui.alert("没有选择办公用品！");
			}else{
			    alert(2);
				$("#listform").submit();
			}
			//mui.alert(map[58], "tijiao");
			//mui.alert(x, "jiao");
		/* 	$.ajax({
				type: "POST",
				url: '/xxzx/officeSupplies/tjlist.do',
			    data: {map	:map,lis:lis},
				dataType:'json',
				cache: false,
				success: function(data){}
			}) */
		}
		document.getElementById("toastBtn").addEventListener('tap', function() {
			var inp=document.getElementsByClassName("mui-input-numbox");
			var map={};
			var lis=[];
			var j=0;
			for(var i=0;i<inp.length;i++){
				//mui.alert(inp[i].id+":"+inp[i].value);
				//mui.alert(1, "111");
				if(inp[i].value>0){
					var a=inp[i].id;
					map[a]=inp[i].value;
					var b = inp[i].value;
					lis[j]={a,b};
					j++;
				} 
				//var len =lis.length;
				/* for(var i=0;i<len;i++){
					mui.alert(map[i], "tijiao");
				} */
				var x = lis.length+",,"
				
			}
			document.getElementById("map").value = JSON.stringify(map);
			document.getElementById("lis").value = lis;
			map =  JSON.stringify(map); 
			//alert(j);
			if(j<=0){
				mui.toast('没有选择办公用品！');
			}else{
				$("#listform").submit();
			}
			});
	</script>
</html>
