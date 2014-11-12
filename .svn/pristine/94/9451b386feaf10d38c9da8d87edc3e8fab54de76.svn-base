<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>


<script src="../../js/cloud.js" type="text/javascript"></script>
<link href="../../css/style.css" rel="stylesheet" type="text/css" />
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
	    }
    function loginSubmit_bind(){
		$(".loginbtn").bind("click",function(){
				$.ajax({
						type:"post",
						url:"../../userLogin.do",
						data:{userName:"11",password:"22"},
						dataType:"json",
						success:function(data){
								alert(data.result+"##");
							}
					});
			});
        }
    function login_validate(){
		var userName = $(".loginuser").val();
		var password = $(".loginpwd").val();
		var userType = $("#userType option:selected").val();
		
        }
</script> 

<body style="background-color:#1c77ac; background-image:url(image/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">



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
       
    <div class="loginbox">
    <form name="loginForm" onsubmit="return false;">
    <ul>
    <li><span id="LoginInfo"></span><li>
    <li><input name="userName" type="text" class="loginuser" /></li>
    <li><input name="password" type="password" class="loginpwd" /></li>
    <li>
    	<label>用户类型</label>:
    	<select name="userType" id="userType" class="userType">
    		<option value="admin">管理员</option>
    		<option value="user">系统用户</option>
    	</select>
    </li>
    <li><input type="button" class="loginbtn" value="登录"   /></li>
    </ul>
    </form>
    
    </div>
    
    </div>
    
    
    
    <div class="loginbm">版权所有  2013  <a href="http://www.uimaker.com">uimaker.com</a>  仅供学习交流，勿用于任何商业用途</div>
	
    
</body>