package com.weir.daoImpl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.weir.dao.BaseDao;
import com.weir.dao.IActivityDao;
import com.weir.entiy.Activity;

@Repository
public class ActivityDaoImpl extends BaseDao<Activity> implements IActivityDao {
	// @PersistenceContext
	// EntityManager em;
	// public void serEm(EntityManager em){
	// this.em = em;
	// }
	@Override
	public void save(Activity act) {
		// TODO Auto-generated method stub
		super.save(act);

	}

	@Override
	public List getAllActivity(int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		String hql = "from Activity";
		List<Activity> list = super.findAll(hql, (pageNum - 1) * pageSize,
				pageSize);
		return list;
	}

	@Override
	public int getActivityCount() {
		// TODO Auto-generated method stub
		//ery query = em.createNativeQuery("select count(activity_id) from activity");
		
		String hql = "select count(activity_id) from Activity";
		int count = super.getTotalSize(hql);
		return count;
	}

	@Override
	public Activity getActivityById(Integer activityId) {
		// TODO Auto-generated method stub
		Activity act = super.findOne(activityId);
		return act;
	}

	@Override
	public int getMaxActivityId() {
		// TODO Auto-generated method stub
		Query query = em.createQuery("select max(activity_id) from activity");
		int maxId = ((Long) query.getSingleResult()).intValue();
		return maxId;
	}

}
