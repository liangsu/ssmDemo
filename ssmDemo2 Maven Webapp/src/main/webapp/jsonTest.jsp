<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'jsonTest.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script src="//cdn.bootcss.com/jquery/2.1.1-rc2/jquery.min.js"></script>
  </head>
  
  <body>
    <button onclick="requestJson()">请求json，响应json</button>
    <button onclick="responseJson()">响应json</button>
    <div id="jsonDiv"></div>
  </body>
<script type="text/javascript">
function requestJson(){
	$.ajax({
		type : 'post',
		url : '${pageContext.request.contextPath}/requestJson.action',
		data : '{"username":"德玛西亚","age":"22"}',
		dataType : 'json',
		contentType : 'application/json;charset=utf-8',
		success : function(data){
			console.log(data);
			appendData(data);
		}
	});
}

function responseJson(){
	$.ajax({
		type : 'post',
		url : '${pageContext.request.contextPath}/responseJson.action',
		dataType : 'json',
		success : function(data){
			console.log(data);
			appendData(data);
		}
	});
}

function appendData(data){
	var len = data.length;
	var li;
	
	if(len){
		$("#jsonDiv").text("");
		for(var i = 0;i < len; i++){
			li = "姓名："+data[i].username+" 年龄:"+data[i].age +"<br/>";
			$("#jsonDiv").append(li);
		}
	}else{
		$("#jsonDiv").text("");
		li = "姓名："+data.username+" 年龄:"+data.age;
		$("#jsonDiv").append(li);
	}
}

</script>
</html>
