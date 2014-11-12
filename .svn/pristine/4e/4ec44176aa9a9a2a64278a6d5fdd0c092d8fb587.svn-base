<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<h2 class="contentTitle">抽奖情况</h2>

<div>
	<input type="hidden" name="activityId" id="activityId" value="${param.activityId}"/>
</div>
<div class="pageContent" layoutH="60">
	<table class="list" id="lottery_table" width="100%" layoutH="94">
		<thead>
			<tr>
				<th width="30">序号</th>
				<th width="30">活动编号</th>
				<th width="120">奖项名称</th>
				<th width="80" >奖项内容</th>
				<th width="80" >抽奖时间</th>
			</tr>
		</thead>
		<tbody id="tbody">
			
		</tbody>
	</table>

		<div class="formBar">
			<ul>
			</ul>
</div>
		</div>
<script type="text/javascript">
	$(function(){
		initPage();
		});
	function initPage(){
		$.ajax({
				type:"post",
				dataType:"json",
				url:"/lottery-core/lotteryInfo.do",
				data:{},
				success:function(data){
					var str="";
					 $.each(data.infoList,function(i,value){
					 	str+="<tr>"+
					 		  "<td width='30'>"+(i+1)+"</td>"+
					 		  "<td width='30'>"+value.activityName+"</td>"+
					 		  "<td width='120'>"+value.awardName+"</td>"+
					 		  "<td width='80'>"+value.awardContent+"</td>"+
					 		  "<td width='80'>"+value.lotteryTime+"</td></tr>";
					 		  });
						$("#tbody",navTab.getCurrentPanel()).html(str);
						$("#lottery_table",navTab.getCurrentPanel()).cssTable();
						$("#lottery_table",navTab.getCurrentPanel()).initUI();
					},
				error:function(){
						alertMsg.error("error");
					}
				
			});
		}
</script>