<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%> 
    <%@ page import = "com.model.*" %>
    <%@ page import = "java.util.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>Insert title here</title> 
<link href="<%=request.getContextPath()%>/css/admin.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/css/pintuer.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/style.css" type="text/css"> 
 
 
  </head>
  
  <body >
        <div class="xs6 xm4 xs3-move xm4-move">       
              <form action="MyServlet" method="post" onsubmit="return validate();">
            <input type="hidden" name="command" value="add">
 
     <div>药品名称：<input type="text"  name="medicine_name"></div>
     <div>药品详情：<input type="text"  name="medicine_detail"></div>
     <div>药品类型：
            <select name="medicine_cata">
	<option value="中药">中药</option>
	<option value="西药">西药</option> 
	</select>
	</div>
        
     <div> <input type="submit" value="提交"> </div>
    	 	 
            </form>   
  

</body>
</html>
