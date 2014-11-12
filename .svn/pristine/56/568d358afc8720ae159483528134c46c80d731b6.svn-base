<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<h2 class="contentTitle">活动规则</h2>

<div>
	<input type="hidden" name="activityId" id="activityId" value="${param.activityId}"/>
	<input type="hidden" name="lotteryTime" id="lotteryTime"/>
</div>
<div class="pageFormContent" layoutH="60">
	<table class="list" id="activity_table" width="100%" layoutH="94">
		<thead>
			<tr>
				<th width="30">序号</th>
				<th width="30">活动编号</th>
				<th width="120">奖项编号</th>
				<th width="120">奖项名称</th>
				<th width="80" >奖项内容</th>
			</tr>
		</thead>
		<tbody id="tbody">
			
		</tbody>
	</table>

		<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="button" class="submit" id="lottery_submit">开始抽奖</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div></li>
			</ul>
		</div>
</div>
<script type="text/javascript">
	$(function(){
			alertMsg.info("init");
			lottery_submit_bind();
			init_activity_rule();
		})
		
	Date.prototype.format = function(pattern) {
	    /*初始化返回值字符串*/
	    var returnValue = pattern;
	    /*正则式pattern类型对象定义*/
	    var format = {
	        "y+": this.getFullYear(),
	        "M+": this.getMonth()+1,
	        "d+": this.getDate(),
	        "H+": this.getHours(),
	        "m+": this.getMinutes(),
	        "s+": this.getSeconds(),
	        "S": this.getMilliseconds(),
	        "h+": (this.getHours()%12),
	        "a": (this.getHours()/12) <= 1? "AM":"PM"
	    };
	    /*遍历正则式pattern类型对象构建returnValue对象*/
	    for(var key in format) {
	        var regExp = new RegExp("("+key+")");
	        if(regExp.test(returnValue)) {
	            var zero = "";
	            for(var i = 0; i < RegExp.$1.length; i++) { zero += "0"; }
	            var replacement = RegExp.$1.length == 1? format[key]:(zero+format[key]).substring(((""+format[key]).length));
	            returnValue = returnValue.replace(RegExp.$1, replacement);
	        }
	    }
	    return returnValue;
	};

	function init_activity_rule(){
			$.ajax({
				type:"post",
				url:"/lottery-core/activityRule.do",
				data:{activityId:$("#activityId",navTab.getCurrentPanel()).val()},
				dataType:"json",
				success:function(data){
					var str="";
					 $.each(data.awardList,function(i,value){
					 	str+="<tr>"+
					 		  "<td width='30'>"+(i+1)+"</td>"+
					 		  "<td width='30'>"+value.activityId+"</td>"+
					 		  "<td width='120'>"+value.awardId+"</td>"+
					 		  "<td width='120'>"+value.awardName+"</td>"+
					 		  "<td width='80'>"+value.awardContent+"</td></tr>";
					 		  });
								$("#tbody",$.pdialog.getCurrent()).html(str);
								$("#activity_table",$.pdialog.getCurrent()).cssTable();
								$("#activity_table",$.pdialog.getCurrent()).initUI();
					},
				error:function(){
						alertMsg.error("error");
					}
				});
		}
	function lottery(lottery_time){
			$.ajax({
					type:"post",
					url:"/lottery-core/lottery.do",
					data:{lotteryTime:lottery_time,activityId:$("#activityId",navTab.getCurrentPanel()).val()},
					dataType:"json",
					success:function(data){
							alertMsg.info(data.message);
						},
					error:function(){
							alertMsg.info("error");
						}
				});
		}
	function lottery_submit_bind(){
			$("#lottery_submit").bind("click",function(){
				var lottery_time = new Date().format("yyyy-MM-dd HH:mm");
				alertMsg.info(lottery_time);
				$.ajax({
						type:"post",
						url:"/lottery-core/lotteryDateValidate.do",
						data:{activityId:$("#activityId",navTab.getCurrentPanel()).val(),
							  lottery_time:lottery_time
							},
						dataType:"json",
						success:function(data){
								if(data.result==false){
									alertMsg.info(data.message);
									}else{
										alertMsg.info("开始抽奖！"+data.lotteryTime);
										$("#lotteryTime",$.pdialog.getCurrent()).val(data.lotteryTime);
										var lottery_time = $("#lotteryTime",$.pdialog.getCurrent()).val();
										lottery(lottery_time);
										}
								
							},
						error:function(){
								alertMsg.error("error");
							}
					});
			});
			
		}


</script>