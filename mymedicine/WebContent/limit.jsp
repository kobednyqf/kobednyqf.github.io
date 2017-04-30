<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import = "com.model.*" %>
    <%@ page import = "java.util.*" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     <%@ taglib uri="http://displaytag.sf.net/el" prefix="display" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/style.css" type="text/css">
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/displaytag.css" type="text/css">
</head>
<%
  ArrayList<Store> storeList = (ArrayList<Store>) request.getSession(true).getAttribute("storeList");  
request.setAttribute("storeList",storeList); 
%> 
<body>
 
<table align="center" cellPadding="0" cellSpacing="1" class="query" border="1"> 
 	   <display:table uid="user" name="storeList" id="store" pagesize='5'
		 requestURI=""  cellspacing="1" style="width:100%"   class="list">
	  <display:column title="编号" style="text-align:center" sortable="true" property="store_id"/> 
	 <display:column title="药品" style="text-align:center" sortable="true" property="medicine_name"/> 
	  <display:column title="详情" style="text-align:center" sortable="true" property="medicine_detail"/> 
	  <display:column title="生产时间" style="text-align:center" sortable="true"  property="active_time"/>
	  <display:column title="到期时间" style="text-align:center" sortable="true"  property="inactive_time"/>
	  <display:column title="库存量" style="text-align:center" sortable="true"  property="number"/>
	  <display:column title="价格" style="text-align:center" sortable="true" property="price"/>
	  <display:column title="出产地" style="text-align:center" sortable="true"  property="place"/> 
	    
	   </display:table>
	 </table>
 
 
</body>
</html>