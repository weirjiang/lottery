<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>简单实用国产jQuery UI框架 - DWZ富客户端框架(J-UI.com)</title>

<link href="/lottery-core/res/dwz-ria/themes/default/style.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="/lottery-core/res/dwz-ria/themes/css/core.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="/lottery-core/res/dwz-ria/themes/css/print.css" rel="stylesheet" type="text/css" media="print"/>
<link href="/lottery-core/res/dwz-ria/uploadify/css/uploadify.css" rel="stylesheet" type="text/css" media="screen"/>

<script src="/lottery-core/res/dwz-ria/js/jquery-1.7.2.js" type="text/javascript"></script>
<script src="/lottery-core/res/dwz-ria/js/jquery.cookie.js" type="text/javascript"></script>
<script src="/lottery-core/res/dwz-ria/js/jquery.validate.js" type="text/javascript"></script>
<script src="/lottery-core/res/dwz-ria/js/jquery.bgiframe.js" type="text/javascript"></script>
<script src="/lottery-core/res/dwz-ria/xheditor/xheditor-1.2.1.min.js" type="text/javascript"></script>
<script src="/lottery-core/res/dwz-ria/xheditor/xheditor_lang/zh-cn.js" type="text/javascript"></script>
<script src="/lottery-core/res/dwz-ria/uploadify/scripts/jquery.uploadify.js" type="text/javascript"></script>

<!-- svg图表  supports Firefox 3.0+, Safari 3.0+, Chrome 5.0+, Opera 9.5+ and Internet Explorer 6.0+ -->
<script type="text/javascript" src="/lottery-core/res/dwz-ria/chart/raphael.js"></script>
<script type="text/javascript" src="/lottery-core/res/dwz-ria/chart/g.raphael.js"></script>
<script type="text/javascript" src="/lottery-core/res/dwz-ria/chart/g.bar.js"></script>
<script type="text/javascript" src="/lottery-core/res/dwz-ria/chart/g.line.js"></script>
<script type="text/javascript" src="/lottery-core/res/dwz-ria/chart/g.pie.js"></script>
<script type="text/javascript" src="/lottery-core/res/dwz-ria/chart/g.dot.js"></script>

<script src="/lottery-core/res/jquery/jquery-1.8.0.js" type="text/javascript"></script>
<script src="/lottery-core/res/jquery/jquery-1.8.0.min.js" type="text/javascript"></script>

<script src="/lottery-core/res/dwz-ria/bin/dwz.min.js" type="text/javascript"></script>

<script src="/lottery-core/res/dwz-ria/js/dwz.regional.zh.js" type="text/javascript"></script>

<script type="text/javascript">
$(function(){
	DWZ.init("/lottery-core/res/dwz-ria/dwz.frag.xml", {
		debug:false,	// 调试模式 【true|false】
		callback:function(){
			initEnv();
			$("#themeList").theme({themeBase:"/lottery-core/res/dwz-ria/themes"}); // themeBase 相对于index页面的主题base路径
		}
	});
});

</script>
</head>

<body scroll="no">
	<div id="layout">
		<div id="header">
			<div class="headerNav">
				<a class="logo" href="http://j-ui.com">标志</a>
				<ul class="nav">
					<li><a>你好用户：${sessionScope.userId}</a></li>
					<li><a href="/lottery-core/loginOut.do">退出</a></li>
				</ul>
				<ul class="themeList" id="themeList">
					<li theme="default"><div class="selected">蓝色</div></li>
					<li theme="green"><div>绿色</div></li>
					<!--<li theme="red"><div>红色</div></li>-->
					<li theme="purple"><div>紫色</div></li>
					<li theme="silver"><div>银色</div></li>
					<li theme="azure"><div>天蓝</div></li>
				</ul>
			</div>

			<!-- navMenu -->
			
		</div>

		<div id="leftside">
			<div id="sidebar_s">
				<div class="collapse">
					<div class="toggleCollapse"><div></div></div>
				</div>
			</div>
			<div id="sidebar">
				<div class="toggleCollapse"><h2>主菜单</h2><div>收缩</div></div>

				<div class="accordion" fillSpace="sidebar">
					<div class="accordionHeader">
						<h2><span>Folder</span>界面组件</h2>
					</div>
					<div class="accordionContent">
						<ul class="tree treeFolder">
							<li><a href="#" target="navTab">主界面</a>
								<ul>
									<li><a href="/lottery-core/view/user/jionActivity.jsp" target="navTab" rel="joinActivity">查看活动</a></li>
									<li><a href="/lottery-core/view/user/lotteryInfo.jsp" target="navTab" rel="lottery-coreInfo">查看抽奖情况</a></li>
									<li><a href="/lottery-core/view/user/dataTable.jsp" target="navTab" rel="DataTable">DataTable插件的使用</a></li>
								</ul>
							</li>
							
									
						</ul>
					</div>
		
				</div>
			</div>
		</div>
		<div id="container">
			<div id="navTab" class="tabsPage">
				<div class="tabsPageHeader">
					<div class="tabsPageHeaderContent"><!-- 显示左右控制时添加 class="tabsPageHeaderMargin" -->
						<ul class="navTab-tab">
							<li tabid="main" class="main"><a href="javascript:;"><span><span class="home_icon">我的主页</span></span></a></li>
						</ul>
					</div>
					<div class="tabsLeft">left</div><!-- 禁用只需要添加一个样式 class="tabsLeft tabsLeftDisabled" -->
					<div class="tabsRight">right</div><!-- 禁用只需要添加一个样式 class="tabsRight tabsRightDisabled" -->
					<div class="tabsMore">more</div>
				</div>
				<ul class="tabsMoreList">
					<li><a href="javascript:;">我的主页</a></li>
				</ul>
				<div class="navTab-panel tabsPageContent layoutBox">
					<div class="page unitBox">
						<div class="accountInfo">
						</div>
						<div class="pageFormContent" layoutH="80" style="margin-right:230px">
							
						<div class="divider"></div>

						<div class="divider"></div>
						<div class="unit"></div>
						<div class="unit"></div>
						<div class="unit"></div>
						<div class="unit"></div>
						<div class="unit"></div>

						<div class="divider"></div>


						<div class="divider"></div>

						</div>
						
						<div style="width:230px;position: absolute;top:60px;right:0" layoutH="80">
							<iframe width="100%" height="430" class="share_self"  frameborder="0" scrolling="no" src="http://widget.weibo.com/weiboshow/index.php?width=0&height=430&fansRow=2&ptype=1&skin=1&isTitle=0&noborder=1&isWeibo=1&isFans=0&uid=1739071261&verifier=c683dfe7"></iframe>
						</div>
					</div>
					
				</div>
			</div>
		</div>

	</div>

	<div id="footer">Copyright &copy; 2010 <a href="demo_page2.html" target="dialog">DWZ团队</a> 京ICP备05019125号-10</div>
</body>
</html>