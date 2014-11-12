MyTable={
	
	//options由dwzPageBreak产生并传入，修改pagerForm参数
	resetPagerForm : function(options){
		var op=$.extend({targetType:"navTab",rel:"",data:{pageNum:"",numPerPage:"",orderField:"",orderDirection:""},callback:null},options);
		var $parent=op.targetType=="dialog"?$.pdialog.getCurrent():navTab.getCurrentPanel();
		var form=_getPagerForm($parent,op.data);
	},
	//调用dwz的pagination方法，重修渲染分页组件
	rebuildPagination : function(){
		 $("div.pagination").each(function () {
			   var $this = $(this);
			   $this.pagination({
			   totalCount: $this.attr("totalCount"),
			   numPerPage: $this.attr("numPerPage"),
			   pageNumShown: $this.attr("pageNumShown"),
			   currentPage: $this.attr("currentPage")
			   });
			   });
	}
}
