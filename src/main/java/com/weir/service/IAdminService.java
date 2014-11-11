package com.weir.service;

import java.util.List;

import com.weir.entiy.Activity;
import com.weir.entiy.ActivityAward;

public interface IAdminService {
	public void addActivity(Activity act);
	public List getAllActivity(int pageNum,int pageSize);
	public int getActivityCount(int pageNum,int pageSize);
	public void saveAward(ActivityAward aa);
	public List getActivityAwardById(Integer activityId);
	public int getMaxActivitId();
}
