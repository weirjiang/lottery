package com.weir.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.weir.entiy.Activity;
import com.weir.entiy.ActivityAward;
import com.weir.service.IAdminService;

@Controller
@RequestMapping(value="/admin")
public class AdminController {
	@Resource
	private IAdminService adminService;
	@RequestMapping("/addActivity.do")
	public void addActivity(HttpServletRequest request,HttpServletResponse respone) throws IOException{
		String activityName = request.getParameter("activityName");
		String date1 = request.getParameter("date1");
		String date2 = request.getParameter("date2");
		String awardContent = request.getParameter("awardContent");
		Activity act = new Activity(activityName, date1, date2, awardContent);
//		Activity act = new Activity(activityName, date1, date2);
//		int activityId = adminService.getMaxActivitId()+1;
//		ActivityAward aa = new ActivityAward(activityId, "��ο��", awardContent, 0, 0f);
//		adminService.saveAward(aa);
		adminService.addActivity(act);
		Map map = new HashMap();
		map.put("result", "���ӳɹ�����");
		JSONObject object = JSONObject.fromObject(map);
		respone.getWriter().print(object);
	}
	@RequestMapping(value="/activityList.do")
	public void activityList(HttpServletRequest request,HttpServletResponse respone) throws IOException{
		int pagenum = Integer.valueOf(request.getParameter("pagenum"));
		int pagesize = Integer.valueOf(request.getParameter("pagesize"));
		List activityList = adminService.getAllActivity(pagenum,pagesize);
		int totalCount = adminService.getActivityCount(pagenum,pagesize);
		Map map = new HashMap();
		map.put("activityList", activityList);
		map.put("totalCount", totalCount);
		JSONObject json = JSONObject.fromObject(map);
		respone.getWriter().print(json);
	}
	
	@RequestMapping(value="/activity_award.do")
	public void addActivity_award(HttpServletRequest request,HttpServletResponse respone) throws IOException{
		int activityId =Integer.valueOf( request.getParameter("activityId"));
		String awardName = request.getParameter("awardName");
		String awardContent = request.getParameter("awardContent");
		int awardCount = Integer.valueOf(request.getParameter("awardCount"));
		float awardProbability = Float.valueOf(request.getParameter("awardProbability"));
		ActivityAward aa =  new ActivityAward(activityId, awardName, awardContent, awardCount, awardProbability);
		adminService.saveAward(aa);
		Map map = new HashMap();
		map.put("message", "������ӳɹ�");
		JSONObject object = JSONObject.fromObject(map);
		respone.getWriter().print(object);
	}
	
	@RequestMapping(value="/activityInfo.do")
	public ModelAndView getActivityIfno(HttpServletRequest request){
		Integer activityId = Integer.valueOf(request.getParameter("activityId"));
		List list = adminService.getActivityAwardById(activityId);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/activityInfo");
		mav.addObject("awardList", list);
		return mav;
	}
}
