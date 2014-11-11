package com.weir.daoImpl;

import java.util.Iterator;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.weir.dao.BaseDao;
import com.weir.dao.IActivityAwardDao;
import com.weir.entiy.ActivityAward;
@Repository
public class ActivityAwardDaoImpl extends BaseDao<ActivityAward> implements IActivityAwardDao {

	@Override
	public void save(ActivityAward aa) {
		super.save(aa);
	}

	@Override
	public List getActivityAwardById(Integer activityId) {
		// TODO Auto-generated method stub
		
		Query query = em.createQuery("from ActivityAward aa where aa.activityId=:activityId");
		query.setParameter("activityId", activityId);
		@SuppressWarnings({ "unchecked", "rawtypes" })
		List<ActivityAward> list = query.getResultList();
		return list;
	}

	@Override
	public int getAwardIdByProbility(Float rate,Integer activityId) {
		// TODO Auto-generated method stub
		Query query = em.createQuery("select award_id from activity_award aa where aa.activity_id=?1 and aa.award_probability=?2");
		query.setParameter(1, activityId);
		query.setParameter(2, rate);
		int awardId = query.getFirstResult();
		return awardId;
	}

	@Override
	public ActivityAward getAward(Integer activityId, Integer awardId) {
		// TODO Auto-generated method stub
		Query query = em.createQuery("from ActivityAward aa where aa.activityId=?1 and aa.awardId=?2");
		query.setParameter(1, activityId);
		query.setParameter(2, awardId);
		List<ActivityAward> list = query.getResultList();
		ActivityAward aa = new ActivityAward();
		Iterator<ActivityAward> it = list.iterator();
		if(it.hasNext()){
			aa = it.next();
		}
		return aa;
	}

}
