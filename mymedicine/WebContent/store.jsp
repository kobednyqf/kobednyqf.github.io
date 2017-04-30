<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%> 
    <%@ page import = "com.model.*" %>
    <%@ page import = "java.util.*" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
 
 <%
 ArrayList<Medicine> medicineList = (ArrayList<Medicine>) request.getSession(true).getAttribute("medicineList");  
 request.setAttribute("medicineList",medicineList);
 %>
  </head>
  
  <body >
        <div class="xs6 xm4 xs3-move xm4-move">       
              <form action="MyServlet" method="post" onsubmit="return validate();">
            <input type="hidden" name="command" value="storeAdd">
 
     <div>药品名称：
        <select name = "medicine_id"  >
         <c:forEach var="index" begin="1" end="${medicineList.size()}" step="1"> 
         <option value="${medicineList[index-1].getMedicine_id()}">${medicineList[index-1].getMedicine_name()}</option>
         </c:forEach>
         </select>
         </div>
     <div>药品数量：<input type="text"  name="number"></div>
     <div>药品产地：<input type="text"  name="place"> </div>
     <div>生产时间：<input type="text"  name="active_time"> </div>
     <div>到期时间：<input type="text"  name="inactive_time"> </div>
     <div>药品单价：<input type="text"  name="price"> </div>
           
     <div> <input type="submit" value="提交"> </div>
    	 	 
            </form>   
  

</body>
</html>
