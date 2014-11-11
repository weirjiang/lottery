<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>
<h2 class="contentTitle">设置活动奖项</h2>
<div class="pageFormContent" align="center">
	
	<form method="post" action="#"  id="addActivityAward" onsubmit="return false" align="center">
		<div class="pageFormContent" layoutH="97">
			<input type="hidden" id="activityId" value="${param.activityId}"></input>
			<div class="divider"></div>
			<dl>
				<dt>奖项名称：</dt>
				<dd>
					<input type="text" name="awardName" id="awardName" maxlength="20" class="required" />
					<span class="info"></span>
				</dd>
			</dl>
			<dl>
				<dt>奖项内容：</dt>
				<dd>
					<input type="text" name="awardContent" id="awardContent" maxlength="20" class="required" />
					<span class="info"></span>
				</dd>
			</dl>
			<dl>
				<dt>奖项次数限制：</dt>
				<dd>
					<input type="text" name="award_count" id="award_count" maxlength="20" class="required" />
					<span class="info"></span>
				</dd>
			</dl>
			<dl>
		   		<dt>中奖概率：</dt>
				<dd>
					<input type="text" name="award_Probability" id="award_Probability" maxlength="20" class="required" />
					<span class="info">概率只能为0-1的数字</span>
				</dd>
			</dl>
		</div>
		
		<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="button" class="submit" id="addAward_submit">提交</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div></li>
			</ul>
		</div>
	</form>
	
</div>


<script type="text/javascript">
	$(function(){
	addActivity_submit();
	})
	
	function addAward_validate(){
		var awardName = $("#awardName").val();
		var awardContent = $("#awardContent").val();
		var awardCount = $("#award_count").val();
		var awardProbability =$("#award_Probability").val();
		if(awardName==""){
			alertMsg.info("请输入奖项名称！");
			return false;
		}
		if(awardContent==""){
			alertMsg.info("请输入奖项内容!");
			return false;
		}
		if(awardCount==""){
			alertMsg.info("请输入奖项限制次数！");
			return false;
		}
		if(awardProbability==""){
			alertMsg.info("请输入奖项概率");
			return false;
		}
		return true;
	}
	
	function addActivity_submit(){
		$("#addAward_submit").bind("click",function(){
			if(addAward_validate()==true){
				alertMsg.info("submit");
				$.ajax({
					type:"post",
					data:{activityId:$("#activityId").val(),
						  awardName:$("#awardName").val(),
						  awardContent:$("#awardContent").val(),
						  awardCount:$("#award_count").val(),
						  awardProbability:$("#award_Probability").val()
					},
					dataType:"json",
					url:"/lottery-core/admin/activity_award.do",
					success:function(data){
						alertMsg.info(data.message);
					},
					error:function(){
						alertMsg.error("error");
					}
				});
			}
		});
	}
</script>
