package com.weir.service;

import java.util.List;

import com.weir.entiy.Activity;
import com.weir.entiy.ActivityAward;
import com.weir.entiy.LotteryInfo;
import com.weir.entiy.User;
import com.weir.entiy.UserAward;

public interface IUserService {
	public List getUser();
	public User getUSer(Integer user_id);
	public boolean userLogin(Integer user_id,String password,String userType);
	public List getActivityRuleById(Integer activityId);
	public Activity getActivityById(Integer activityId);
	public List getAwardByActivityId(Integer activityId);
	public UserAward lottery(Integer activityId,Integer userId,String lottery_time);
	//获取活动的可抽奖项，将那些次数已经用完的排除
	public List<ActivityAward> getLottrtyAward(Integer activityId);
	//获取用户当天的抽奖次数
	public int getLotteryCount(Integer userId,String time);
	public void save(UserAward ua);
	public ActivityAward getaward(Integer activityId,Integer awardId);
	public List<LotteryInfo > getLotteryInfo(Integer userId);
}
