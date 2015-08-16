<%@page import="java.sql.ResultSet"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'film.jsp' starting page</title>
    
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
  
    <div id="message">
  		<%
  			ResultSet rs = (ResultSet)session.getAttribute("result");
  			while(rs.next()){
  				//out.print(rs.toString());
  				out.print(rs.getInt("film_id")+"|");
  				out.print(rs.getString("title")+"|");
  				out.print(rs.getString("description")+"|");
  				out.print(rs.getString("name"));
  				out.print("<br>");
  				%>
  				
  			<form action="<%=request.getContextPath() %>/DeleteServlet",method="post">
  				<%
  					request.setAttribute("film_id", rs.getInt("film_id"));
  				 %>
  				 
  				<input type="submit" value="删除">
  			</form>

  			<%	
  			}
  		 %>
  		 <%--
  		 	out.print(request.getAttribute("msg"));
  		  --%>

  		<a href="login.jsp">return loginIndex</a>
  		
  		
  	</div>
  </body>
</html>
