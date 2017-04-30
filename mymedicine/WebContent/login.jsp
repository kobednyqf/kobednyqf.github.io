<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%> 
 
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
  </head>
  
  <body>
  <div class="bg"></div>
<div class="container">
    <div class="line bouncein">
        <div class="xs6 xm4 xs3-move xm4-move">
            <div style="height:150px;"></div>
            <div class="media media-y margin-big-bottom">           
            </div>         
            <form action="<%=request.getContextPath()%>/LoginServlet" method="post">
            <div class="panel loginbox">
                <div class="text-center margin-big padding-big-top"><h1>京正元药店管理系统</h1></div>
                <div class="panel-body" style="padding:30px; padding-bottom:10px; padding-top:10px;">
                    <div class="form-group">
                        <div class="field field-icon-right">
                            <input type="text" class="input input-big" id="username1" name="username"  />
                            <span class="icon icon-user margin-small"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="field field-icon-right">
                              <input type="password" class="input input-big" id="password1" name="password" />
                            <span class="icon icon-key margin-small"></span>
                        </div>
                    </div>  
                </div>
               <div style="padding:30px;"> 
                 <input type="submit" class="button button-block bg-main text-big input-big" value="登录">
                 </div>
                
            </div> 
            </form>   
        </div>
    </div>
</div>

</body>
</html>
