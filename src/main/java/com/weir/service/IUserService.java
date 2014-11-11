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
	//��ȡ��Ŀɳ齱�����Щ�����Ѿ�������ų�
	public List<ActivityAward> getLottrtyAward(Integer activityId);
	//��ȡ�û�����ĳ齱����
	public int getLotteryCount(Integer userId,String time);
	public void save(UserAward ua);
	public ActivityAward getaward(Integer activityId,Integer awardId);
	public List<LotteryInfo > getLotteryInfo(Integer userId);
}
