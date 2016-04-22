<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'user.jsp' starting page</title>
    
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
  <c:forEach items="${allErrors }" var="error">
  	${error.defaultMessage }
  </c:forEach>
  <form action="${pageContext.request.contextPath }/editUser.action" method="post" enctype="multipart/form-data">
  <input type="hidden" name="id" value="${user.id }">
   <input type="hidden" name="date" value="2015-01-01 22:23:44">
       姓名：<input type="text" name="username" value="${user.username }"><br/>
       密码：<input type="text" name="password" value="${user.password }"><br/>
       <c:if test="${user.photo ne null and user.photo ne '' }">
       	<img src="${pageContext.request.contextPath }/img/${user.photo}"><br/>
       </c:if>
       <input type="file" name="photo_pic"/><br/>
      <input type="submit" value="提交"><br/>
   </form>
  </body>
</html>
