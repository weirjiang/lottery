<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="/lottery-core/js/MyTable.js"></script>
<form id="pagerForm" method="post"  action="">
	<input type="hidden" id="pageNum" name="pageNum" value="1" />
	<input type="hidden" id="numPerPage" name="numPerPage" value="5" />
	<input type="hidden" name="activityId" id="activityId" />
</form>
<div class="pageHeader">
	
	<form   id="searchForm" method="post" rel="pagerForm" onsubmit= "return false">
	<div class="searchBar">
		<table class="searchContent">
		</table>
		<div class="subBar">
			<ul>

			</ul>
		</div>
	</div>
	</form>
</div>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="edit" id="edit1"><span>查看活动情况</span></a></li>
			<li><a class="edit" id="edit2"><span>活动设置</span></a></li>
			<li class="line">line</li>
		</ul>
	</div>
	
	<table class="list" id="activity_table" width="100%" layoutH="94">
		<thead>
			<tr>
				<th width="30">序号</th>
				<th width="80">活动编号</th>
				<th width="120">活动名称</th>
				<th width="80" >开始时间</th>
				<th width="80" >结束时间</th>
			</tr>
		</thead>
		<tbody id="tbody">
				<tr>
				</tr>
		</tbody>
	</table>
	</div>
	<div class="panelBar">
			<div class="pages">
				<span>显示</span>
				<select class="combox" name="numPerPage" onchange="navTabPageBreak({numPerPage:this.value})">
					<option value="5">5</option>
					<option value="10">10</option>
					<option value="15">15</option>
					<option value="200">200</option>
				</select>
				<span >条，共0条</span>
			</div>	
		<div class="pagination" targetType="navTab" totalCount="2" numPerPage="5" pageNumShown="8" currentPage="1"></div>
	</div>

<script type="text/javascript">
	$(function(){
			getSelectedTr();
			loadTable();
			activity_edit1_bind();
			activity_edit2_bind();
		});
		
		
	
	/**
 * 需要重写dwz的这个方法，dwz默认重新加载pagerFrom中的action，而我使用ajax操作，所以不符合要求。
 * @param options
 */

function dwzPageBreak(options){
	MyTable.resetPagerForm(options);
	var pageNum = $("#pageNum").val();
	$(".pagination").attr("currentPage",pageNum);
	var numPerPage = $("[name='numPerPage']",navTab.getCurrentPanel()).val();
	$(".pagination").attr("numPerPage",numPerPage);
	var pageNum = $("#pagerForm [name='pageNum']",navTab.getCurrentPanel()).val();
	$(".pagination").attr("currentPage",pageNum);
	MyTable.rebuildPagination();
	loadTable();
}



function loadTable(){
	var url = "/lottery-core/admin/activityList.do";
	var pageNum = $("#pagerForm [name='pageNum']",navTab.getCurrentPanel()).val();
	var numPerPage = $("#pagerForm [name='numPerPage']",navTab.getCurrentPanel()).val();
	if(pageNum==null || pageNum == ""){
		pageNum = 1;
	}
	if(numPerPage==null || numPerPage == ""){
		numPerPage = 5;
	}
	var pageParam = {"pagenum":pageNum,"pagesize":numPerPage};
	ajax_post(url,pageParam);
	}
	function ajax_post(url,pageParam){
		
		$.post(url,pageParam,function(data){
			var str="";
			 $.each(data.activityList,function(i,value){
			 	str+="<tr>"+
			 		  "<td width='30'>"+(i+1)+"</td>"+
			 		  "<td width='80'>"+value.activityId+"</td>"+
			 		  "<td width='120'>"+value.activityName+"</td>"+
			 		  "<td width='80'>"+value.startTime+"</td>"+
			 		  "<td width='80'>"+value.endTime+"</td></tr>";
			 		  });
						$("#tbody",navTab.getCurrentPanel()).html(str);
						$("#activity_table",navTab.getCurrentPanel()).cssTable();
						$("#activity_table",navTab.getCurrentPanel()).initUI();
						var totalCount = data.totalCount;
						$(".pages span",navTab.getCurrentPanel()).last().html("条 共"+totalCount+" 条");
						$("div.pagination",navTab.getCurrentPanel()).attr("totalCount",totalCount);
						MyTable.rebuildPagination();
						getSelectedTr();
			},"json");
			
	}
			//获取选中一行的id
		function getSelectedTr(){
			var trs=$("#activity_table tbody tr",navTab.getCurrentPanel());
			$("#activity_table tbody tr",navTab.getCurrentPanel()).each(function(index,tr){
				$(tr).click(function(){
					var activity_id = $(tr).children('td').eq(1).html();
					$("#activityId",navTab.getCurrentPanel()).val(activity_id);
					alertMsg.info($(tr).children('td').eq(1).html());
				});
				
			});
		}
		
		
		function activity_edit2_bind(){
			$("#edit2").bind("click",function(){
				if($("#activityId",navTab.getCurrentPanel()).val()==""){
					alertMsg.info("请选择一行数据");
				}else{
					var activityId = $("#activityId",navTab.getCurrentPanel()).val();
					$.pdialog.open("/lottery-core/view/admin/addAward.jsp?activityId="+activityId, "activity_award", "设置活动奖项",{});
						
				}

			});
		}
		function activity_edit1_bind(){
			$("#edit1").bind("click",function(){
				if($("#activityId",navTab.getCurrentPanel()).val()==""){
					alertMsg.info("请选择一行数据");
				}else{
					var activityId = $("#activityId",navTab.getCurrentPanel()).val();
					$.pdialog.open("/lottery-core/admin/activityInfo.do?activityId="+activityId, "activityAwardInfo", "查看活动情况",{});
					
				}

			});
		}
		
</script>