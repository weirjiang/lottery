package com.weir.dao;

import java.util.List;

import com.weir.entiy.ActivityAward;

public interface IActivityAwardDao {
	public void save(ActivityAward aa);
	public List getActivityAwardById(Integer activityId);
	public int getAwardIdByProbility(Float rate,Integer activityId);
	public ActivityAward getAward(Integer activityId,Integer awardId);
}
