<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head>
	<title>Home</title>
	<!--  <script type="text/javascript" src="http://localhost:8090/mvc/WEB-INF/js/ZTree/jquery-1.4.4.min.js"></script>-->
	<script type="text/javascript" src="<%=basePath%>js/ZTree/jquery-1.4.4.min.js"></script>

</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
登录名：<input type="text" name ="login_code"/>
密码：<input type="password" name="password"/>
<input type="button" name ="login" id="submit"/>
<a name="aaa" href ="<%=basePath%>wurenjie/success.do">跳转</a>
<script type="text/javascript">
$(document).ready(function(){
	$('#submit').click(function(){
		$("a[name=aaa]").click();
		var login_code = document.getElementsByName('login_code');
		var password = document.getElementsByName('password');
		console.log($("input[name=login_code]").val());
		console.log($("input[name=password]").val());	
		$.ajax({
			type:'post',
			url:"<%=basePath%>wurenjie/login.do",
			datatype : "json",
			//contentType : "application/json; charset=utf-8",
			contentType:'application/x-www-form-urlencoded',
			data:{
				"login_code" : $("input[name=login_code]").val(),
				"password" :  $("input[name=password]").val()
			},
			success:function (content,textStatus,aaa){
				alert('dd');
				debugger;
				if(content.success){
					console.log(content.login);
					console.log(content.password);
				}
			}
		})
	});
});
</script>
</body>
</html>
