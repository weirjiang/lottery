package com.weir.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.weir.entiy.Activity;
import com.weir.entiy.ActivityAward;
import com.weir.entiy.LotteryInfo;
import com.weir.entiy.UserAward;
import com.weir.service.IUserService;
import com.weir.util.CommonUtil;
@Controller
public class UserController {
	private String validateTime="";
	@Resource
	private IUserService userService;
	CommonUtil util = new CommonUtil();
	@RequestMapping(value="/userLogin.do")
	public ModelAndView  userLogin(HttpSession session,HttpServletRequest request) throws IOException{
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String userType = request.getParameter("userType");
		Integer userId = Integer.valueOf(userName);
		boolean b = userService.userLogin(userId, password, userType);
		ModelAndView mav = new ModelAndView();
		System.out.println("login is"+b);
		if(b){
			if(userType.equals("admin")){
				mav.setViewName("admin/admin_index");
				session.setAttribute("userId", userName);
			}else{
				mav.setViewName("user/user_index");
				session.setAttribute("userId", userName);
			}
		}else{
			mav.setViewName("sys/userLogin");
			mav.addObject("error", "�û�����������������µ�¼!");
		}
		return mav;
	}
	@RequestMapping(value="/activityRule.do")
	public void getActivityRule(HttpServletRequest request,HttpServletResponse response) throws IOException{
		Integer activityId = Integer.valueOf(request.getParameter("activityId"));
		List list = userService.getActivityRuleById(activityId);
		Map map = new HashMap();
		map.put("awardList", list);
		new CommonUtil().jsonUtil(map, response);
	}
	
	@RequestMapping(value="/lotteryDateValidate.do")
	public void lotteryDateValidate(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException{
		Integer activityId = Integer.valueOf(request.getParameter("activityId"));
//		String lotteryTime = request.getParameter("lottery_time");
		Activity act = userService.getActivityById(activityId);
		String startTime = act.getStartTime();
		String endTime = act.getEndTime();
		String lotteryTime = util.genterateDate();
		session.setAttribute("lotteryTime", lotteryTime);
		int diff1 = util.compare_date(startTime, lotteryTime);
		int diff2 = util.compare_date(lotteryTime, endTime);
		Integer userId = Integer.valueOf((String) session.getAttribute("userId"));
		Map map = new HashMap();
		String message =null;
		boolean flag=true;        
		if(diff1<0){
			message = "�Բ��𣬻��δ��ʼ��";
			flag = false;
		}else if(diff2<0){
			message = "�Բ��𣬻�Ѿ�������";
			flag=false;
		}else{
			List<ActivityAward> aList = userService.getAwardByActivityId(activityId);
			if(aList.size()==0){
				flag=false;
				message="�Բ��𣬻����δ���ý���!�����޷��齱";
			}else{
				int lotteryCount = userService.getLotteryCount(userId, lotteryTime.substring(0, 10));
				if(lotteryCount>=5){
					flag=false;
					message = "�Բ��������5�γ齱�����Ѿ����꣡";
				}else{
					message ="�õģ����ڿ�ʼ�齱!";
					map.put("lotteryTime", lotteryTime);
					validateTime = lotteryTime;
				}
				
			}

			}
		
		map.put("message", message);
		map.put("result", flag);
		util.jsonUtil(map, response);
	}
	@RequestMapping(value="/lottery.do")
	public void lottery(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException{
		Integer userId = Integer.valueOf((String) session.getAttribute("userId"));
		Integer activityId = Integer.valueOf(request.getParameter("activityId"));
		String lotteryTime = request.getParameter("lotteryTime");
		Map<String,String> map = new HashMap<String,String>();
		//��֤�Ƿ��ύ
		String sessionLotteryTime = (String) session.getAttribute("lotteryTime");
		if(sessionLotteryTime!=null){
		if(lotteryTime.equals(sessionLotteryTime)){
			UserAward ua= userService.lottery(activityId, userId,lotteryTime);
			//List awardList = userService.getAwardByActivityId(activityId);
			userService.save(ua);
			if(ua.getAwardId()==0){
				Activity act = userService.getActivityById(activityId);
				map.put("message", "��ϲ���н���"+"��ο��"+"##"+act.getConsolation());
			}else{
				ActivityAward aa = userService.getaward(ua.getActivityId(), ua.getAwardId());
				map.put("message", "��ϲ���н���"+aa.getAwardName()+"##"+aa.getAwardContent());
			}
			session.removeAttribute("lotteryTime");
		}else{
			map.put("message", "�Բ����벻Ҫ�Ƿ��ύ!");
		}
		}else{
			map.put("message", "�Բ����벻Ҫ�Ƿ��ύ!");
		}
		util.jsonUtil(map, response);
	}
	@RequestMapping(value="lotteryInfo.do")
	public void lotteryInfo(HttpSession session,HttpServletResponse response) throws IOException{
		Integer userId = Integer.valueOf((String) session.getAttribute("userId"));
		List<LotteryInfo> list = userService.getLotteryInfo(userId);
		Map<String,List> map = new HashMap<String,List>();
		map.put("infoList", list);
		util.jsonUtil(map, response);
	}
	
	@SuppressWarnings("null")
	@RequestMapping(value="/loginOut.do")
	public ModelAndView loginOut(HttpSession session){
		ModelAndView mav = new ModelAndView();
		session.invalidate();
		mav.setViewName("sys/userLogin");
		return mav;
	}
}
