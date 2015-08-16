<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'error.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
	<div id ="message">
		login fail!<br>
		the worng is:<br>
		<%
			Object obj = request.getAttribute("msg");
			if(obj!=null){
			out.print(obj.toString());
			}else{
				out.print("nothing");
			}
		 %>
		your login information is:<br>
		username:<%=request.getParameter("firstname") %><br>
		<a href="login.jsp">return loginIndex</a>
		
	</div>

  </body>
</html>
