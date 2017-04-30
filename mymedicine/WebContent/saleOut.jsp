<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
 Store  store = (Store) request.getSession(true).getAttribute("store");  
request.setAttribute("store",store); 
%>  

  </head>
 
  <body >
        <div class="xs6 xm4 xs3-move xm4-move">       
          <form action="MyServlet?command=storeSuccess" method="post" onsubmit="return validate();">
              <input type="hidden" name="store_id" value="${store.getStore_id() }">  
              <input type="hidden" name="limit_number" value="${store.getNumber() }">  
              <input type="hidden" name="store_price" value="${store.getPrice() }"> 
              <div>编号：${store.getStore_id() }</div>   
              <div>药品：${store.getMedicine_name()}</div>  
              <div>详情：${store.getMedicine_detail()}</div>    
              <div>数量：<input type="text"  name="number"></div>  
              <div><input type="submit" value="提交"></div> 	 
          </form>   
        </div>
<script>
  function validate(){ 
	  	 
	    var limit_number= +document.getElementsByName("limit_number")[0].value; 
	    var number= +document.getElementsByName("number")[0].value; 
	    if(number>limit_number){
	  	  alert('数量不能大于当前库存量'+limit_number);
	  	  return false;
	    }
	    else {
			var number= +document.getElementsByName("number")[0].value; 
			var price= +document.getElementsByName("store_price")[0].value;
			var totalprice=number*price;
			alert('请收款'+totalprice+'元');
	    }
   }
  
</script>
</body>
</html>
