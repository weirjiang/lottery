package com.weir.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.weir.dao.BaseDao;
import com.weir.dao.IActivityAwardDao;
import com.weir.dao.IActivityDao;
import com.weir.entiy.Activity;
import com.weir.entiy.ActivityAward;
import com.weir.service.IAdminService;
@Service
public class AdminServiceImpl implements IAdminService{
	@Resource
	private IActivityDao activityDao;
	@Resource
	private IActivityAwardDao activityAwardDao;	
	@Override
	@Transactional
	public void addActivity(Activity act) {
		// TODO Auto-generated method stub
		activityDao.save(act);
	}
	@Override
	public List getAllActivity(int pageNum,int pageSize) {
		// TODO Auto-generated method stub
		return activityDao.getAllActivity(pageNum,pageSize);
	}
	@Override
	public int getActivityCount(int pageNum,int pageSize) {
		// TODO Auto-generated method stub
		return activityDao.getActivityCount();
	}
	@Override
	@Transactional
	public void saveAward(ActivityAward aa) {
		// TODO Auto-generated method stub
		activityAwardDao.save(aa);
	}
	@Override
	public List getActivityAwardById(Integer activityId) {
		// TODO Auto-generated method stub
		return activityAwardDao.getActivityAwardById(activityId);
	}
	@Override
	public int getMaxActivitId() {
		// TODO Auto-generated method stub
		return activityDao.getMaxActivityId();
	}

}
