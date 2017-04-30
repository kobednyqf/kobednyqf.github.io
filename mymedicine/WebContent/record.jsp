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
  ArrayList<Sale> saleList = (ArrayList<Sale>) request.getSession(true).getAttribute("saleList");  
request.setAttribute("saleList",saleList); 
%> 
<body>
 
<table align="center" cellPadding="0" cellSpacing="1" class="query" border="1"> 
 	   <display:table uid="user" name="saleList" id="sale" pagesize='5'
		 requestURI=""  cellspacing="1" style="width:100%"   class="list">
	  <display:column title="编号" style="text-align:center" sortable="true" property="sale_id"/> 
	 <display:column title="药品" style="text-align:center" sortable="true" property="medicine_name"/> 
	  <display:column title="类型" style="text-align:center" sortable="true" property="medicine_cata"/> 
	  <display:column title="出售价格" style="text-align:center" sortable="true"  property="price"/>
	  <display:column title="出售数量" style="text-align:center" sortable="true"  property="number"/>
	  <display:column title="出售时间" style="text-align:center" sortable="true"  property="create_time"/>
 	   
	   </display:table>
	 </table>
 
 
</body>
</html>