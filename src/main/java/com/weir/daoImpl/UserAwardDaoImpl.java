package com.weir.daoImpl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.weir.dao.BaseDao;
import com.weir.dao.IUserAwardDao;
import com.weir.entiy.UserAward;
@Repository
public class UserAwardDaoImpl extends BaseDao<UserAward> implements IUserAwardDao {

	@Override
	public int getAwardCountById(Integer activityId, Integer awardId) {
		// TODO Auto-generated method stub
		Query query=  em.createQuery("select count(*) from UserAward ua where ua.activityId=?1 and ua.awardId =?2");
		query.setParameter(1, activityId);
		query.setParameter(2, awardId);
		int count =((Long) query.getSingleResult()).intValue();
		return count;
	}

	@Override
	public void save(UserAward ua) {
		// TODO Auto-generated method stub
		super.save(ua);
	}

	@Override
	public List<UserAward> getUserAward(Integer userId) {
		// TODO Auto-generated method stub
		Query query = em.createQuery("from UserAward ua where ua.userId = ?1 ");
		List<UserAward> list = query.setParameter(1, userId).getResultList();
		return list;
	}

}
