<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>
<h2 class="contentTitle">活动情况</h2>
<div class="pageFormContent" align="center">
	
	<form method="post" action="#"  id="addActivityAward" onsubmit="return false" align="center">
		<div class="pageFormContent" layoutH="97">
			<input type="hidden" id="activityId" value="${param.activityId}"></input>
			<div class="divider"></div>
	<table class="list" id="activity_table" width="100%" layoutH="94">
		<thead>
			<tr>
				<th width="80">活动编号</th>
				<th width="120">奖项编号</th>
				<th width="120">奖项名称</th>
				<th width="80" >奖项内容</th>
				<th width="80" >奖项限定次数</th>
				<th width="80" >奖项概率</th>
			</tr>
		</thead>
			<c:forEach var="award" items="${awardList}">
				<tr>
					<td>${award.activityId}</td>
					<td>${award.awardId}</td>
					<td>${award.awardName}</td>
					<td>${award.awardContent}</td>
					<td>${award.awardCount}</td>
					<td>${award.awardProbability}</td>
				</tr>
			</c:forEach>
	</table>
		</div>
		
		<div class="formBar">
			<ul>
			</ul>
		</div>
	</form>
	
</div>