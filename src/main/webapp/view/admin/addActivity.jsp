<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<h2 class="contentTitle">添加活动</h2>


<div class="pageContent">
	<form method="post"  onsubmit="return false">
		<div class="pageFormContent nowrap" layoutH="97">
			<div class="divider"></div>
			<dl>
				<dt>活动名称：</dt>
				<dd>
					<input type="text" name="activityName" id="activityName" maxlength="20" class="required" />
					<span class="info"></span>
				</dd>
			</dl>
			<dl>
				<dt>活动开始时间：</dt>
				<dd>
					<input type="text" name="date1" class="date" dateFmt="yyyy-MM-dd HH:mm"  id="date1" readonly="readonly" />
					<a class="inputDateButton" href="javascript:;">选择</a>
					<span class="info"></span>
				</dd>
			</dl>
			<dl>
				<dt>活动结束时间：</dt>
				<dd>
					<input type="text" name="date2" class="date" dateFmt="yyyy-MM-dd HH:mm"  id="date2" readonly="readonly" />
					<a class="inputDateButton" href="javascript:;">选择</a>
					<span class="info"></span>
				</dd>
			</dl>
			<div class="divider"></div>
			<dl>
				<dt>设置安慰奖：</dt>
				<dd>
					<input type="text" name="awardName" id="awardName" readonly="readonly" value="安慰奖"/>
					<span class="info"></span>
				</dd>
			</dl>
			
			<dl>
				<dt>安慰奖内容：</dt>
				<dd>
					<input type="text" name="awardContent" id="awardContent" class="required" />
					<span class="info"></span>
				</dd>
			</dl>
		</div>

	</form>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button id="addActivity_submit" type="submit">提交</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div></li>
			</ul>
		</div>
</div>
<script language="javascript">
	$(function(){
		alertMsg.info("init");
		addActivity_submit_bind();
	   	});  
	   	
	   	function addActivity_validate(){
		var activityName = $("#activityName").val();
		var date1 = $("#date1").val();
		var date2 = $("#date2").val();
		var awardContent = $("#awardContent").val();
		if(activityName==""){
			alertMsg.info("请输入活动名称！");
			return false;
		}
		if(date1 ==""){
			alertMsg.info("请输入活动开始时间！");
			return false;
		}
		
		if(date2 ==""){
			alertMsg.info("请输入活动结束时间！");
			return false;
		}
		if(awardContent==""){
			alertMsg.info("请输入安慰奖的奖项内容！");
			return false;
		}
		return true;
	}
	function addActivity_submit_bind(){
		$("#addActivity_submit").bind("click",function(){
			if(addActivity_validate()==true){
			$.ajax({
				type:"post",
				url:"/lottery-core/admin/addActivity.do",
				data:{activityName:$("#activityName").val(),
					  date1:$("#date1").val(),
					  date2:$("#date2").val(),
					  awardContent: $("#awardContent").val()
				},
				dataType:"json",
				success:function(data){
					alertMsg.info(data.result);
				},
				error:function(XMLResponse){
					alertMsg.info(XMLResponse.responseText);
				}
			});
			}
		});
	}
	
	
</script> 


