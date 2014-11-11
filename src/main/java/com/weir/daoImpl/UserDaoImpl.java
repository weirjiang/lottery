package com.weir.daoImpl;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.weir.dao.BaseDao;
import com.weir.dao.IUserDao;
import com.weir.entiy.User;
@SuppressWarnings("rawtypes")
@Repository
public class UserDaoImpl extends BaseDao<User> implements IUserDao{

	@Override
	public User getUserById(Integer user_id) {
		// TODO Auto-generated method stub
		User user = em.find(User.class,user_id);
		return user;
	}

	@Override
	public int getLotteryCount(Integer userId, String time) {
		// TODO Auto-generated method stub
		Query  query = em.createQuery("select count(*) from UserAward ua where ua.userId=:userId and ua.lotteryTime like :lotteryTime");
		query.setParameter("userId", userId);
		query.setParameter("lotteryTime", "%"+time+"%");
		query.getFirstResult();
		int count = ((Long)query.getSingleResult()).intValue();
	    return count;
	}
}
