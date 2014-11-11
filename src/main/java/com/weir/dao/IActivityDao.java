package com.weir.dao;

import java.util.List;

import com.weir.entiy.Activity;

public interface IActivityDao {
	public void save(Activity act);
	public List getAllActivity(int pageNum,int pageSize);
	public int getActivityCount();
	public Activity getActivityById(Integer activityId);
	public int getMaxActivityId();
}
