<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'userList.jsp' starting page</title>
    
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
  <form action="${pageContext.request.contextPath }/userListEdit.action" method="post">
  	<table border="1px" >
 	<c:forEach var="user" items="${users}" varStatus="status">
   		<tr width="800">
   			<td width="10%"><input type="text" name="userCustomers[${status.count-1 }].id" value="${user.id }" readonly="readonly"/></td>
   			<td width="30%"><input type="text" name="userCustomers[${status.count-1 }].username" value="${user.username }"/></td>
   			<td width="30%"><input type="text" name="userCustomers[${status.count-1 }].password" value="${user.password }"/></td>
 		</tr>
   	</c:forEach>
   		<input type="submit" value="提交">
  	</table>
  </form>
  </body>
</html>
