<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script src="../res/jquery/jquery-1.8.0.js" type="text/javascript"></script>
<script src="../res/jquery/jquery-1.8.0.min.js" type="text/javascript"></script>
<script type="text/javascript" src="../res/jquery/jQueryRotate.js"></script>
<title>range</title>
<style type="text/css">
body {
	background: url(../img/bg.png) 0 0 repeat;
}

.rotate-content {
	width: 270px;
	position: relative;
	height: 270px;
	background: url(../img/bg.png)
		no-repeat 0 0;
	background-size: 100% 100%;
	margin: 0 auto
}

.rotate-con-pan {
	background: url(../img/disk.jpg)
		no-repeat 0 0;
	background-size: 100% 100%;
	position: relative;
	width: 255px;
	height: 255px;
	padding-top: 15px;
	box-sizing: border-box;
	-moz-box-sizing: border-box;
	-webkit-box-sizing: border-box;
	margin: 0 auto
}

.rotate-con-zhen {
	width: 112px;
	height: 224px;
	background: url(../img/start.png)
		no-repeat 0 0;
	background-size: 100% 100%;
	margin: 0 auto
}

</style>
</head>

<body>

<div class="rotate-content">
	<div class="rotate-con-pan">
			<div class="rotate-con-zhen"></div>
	</div>
</div>
</body>
<script type="text/javascript">
$(function(){
	alert("hello");
	$(".rotate-con-zhen").rotate({
		 bind: 
	     { 
	        mouseover : function() { 
	            $(this).rotate({animateTo:180})
	        },
	        mouseout : function() { 
	            $(this).rotate({animateTo:45})
	        }
	     } 
	   
	});
});
</script>
</html>