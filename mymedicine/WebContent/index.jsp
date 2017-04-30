<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%> 
  
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>Insert title here</title>  
 
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/pintuer.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/admin.css"> 
     <script src="<%=request.getContextPath()%>/js/jquery.js"></script>   
 
</head>
 
<body style="background-color:#f2f9fd;">
<div class="header bg-main">
  <div class="logo margin-big-left fadein-top">
    <h1><img src="images/y.jpg" class="radius-circle rotate-hover" height="50" alt="" />京正元药店管理系统
    
</h1>
  </div>
  <div class="head-l"> <a class="button button-little bg-red" href="login.jsp"><span class="icon-power-off"></span> 退出登录</a> </div>
</div>
<div class="leftnav">
   <div class="leftnav-title"><strong><span class="icon-list"></span>菜单列表</strong></div>  
    <a href="add.jsp" target="right"><h2><span class="icon-user"></span>新增药品</h2></a> 
    <a href="MyServlet?command=store" target="right"><h2><span class="icon-user"></span>药品入库</h2></a>
    <a href="MyServlet?command=sale" target="right"><h2><span class="icon-user"></span>出售药品</h2></a>
    <a href="MyServlet?command=record" target="right"><h2><span class="icon-user"></span>销售记录</h2></a>
    <a href="MyServlet?command=past" target="right"><h2><span class="icon-user"></span>过期提醒</h2></a>
    <a href="MyServlet?command=limit" target="right"><h2><span class="icon-user"></span>低于下限提示</h2></a>
</div>
 
<div class="admin">
  <iframe scrolling="auto" frameborder="0"  src="welcome.jsp" name="right" width="100%" height="100%"></iframe>
</div>
 
</body>
</html>