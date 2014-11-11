<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script src="/lottery-core/res/jquery/jquery-1.8.0.js" type="text/javascript"></script>
<script src="/lottery-core/res/jquery/jquery-1.8.0.min.js" type="text/javascript"></script>
<script src="/lottery-core/js/cloud.js" type="text/javascript"></script>
<link href="/lottery-core/css/style.css" rel="stylesheet" type="text/css" />
<script language="javascript">
	$(function(){
		initpage();
		loginSubmit_bind();
	   	});  
	function initpage(){
		$('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
		$(window).resize(function(){  
			$('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
		    })
		   var loginInfo = $("#LoginInfo").val();
		   if(loginInfo!=""){
		   alert(loginInfo+"##");
		   }
	    }

    function login_validate(){
		var userName = $(".loginuser").val();
		var password = $(".loginpwd").val();
		if(userName==""){
			alert("请输入用户名！");
			return false;
		}
		if(password==""){
			alert("请输入密码！");
			return false;
		}
		return true;		
        }
        
        function loginSubmit_bind(){
        	$(".loginbtn").bind("click",function(){
        		if(login_validate()==true){
        			$(".loginForm").submit();
        		}
        		
        	});
        }
</script> 

</head>
<body style="background-color:#1c77ac; background-image:url(lottery-core/img/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">



    <div id="mainBody">
      <div id="cloud1" class="cloud"></div>
      <div id="cloud2" class="cloud"></div>
    </div>  


<div class="logintop">    
    <span>欢迎登录网上抽奖系统</span>    
    <ul>
    </ul>    
    </div>
    
    <div class="loginbody">
    
    <span class="systemlogo"></span> 
    <input type="hidden" id="LoginInfo" value="${error}"></input>
    <div class="loginbox">
    <form name="loginForm" class="loginForm" action="/lottery-core/userLogin.do" method="post">
    <ul>
    <li><input name="userName" type="text" class="loginuser" /></li>
    <li><input name="password" type="password" class="loginpwd" /></li>
    <li>
    	<label>用户类型</label>:
    	<select name="userType" id="userType" class="userType">
    		<option value="admin">管理员</option>
    		<option value="user">系统用户</option>
    	</select>
    </li>
    <li><input type="button" class="loginbtn" value="登录"/></li>
    </ul>
    </form>
    
    </div>
    
    </div>
    
    
    
    <div class="loginbm">版权所有  2013  <a href="http://www.uimaker.com">uimaker.com</a>  仅供学习交流，勿用于任何商业用途</div>
	
    
</body>
</html>