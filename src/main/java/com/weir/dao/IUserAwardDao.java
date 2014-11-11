package com.weir.dao;

import java.util.List;

import com.weir.entiy.UserAward;

public interface IUserAwardDao {
	public int getAwardCountById(Integer activityId,Integer awardId);
	public void save(UserAward ua);
	public List<UserAward> getUserAward(Integer userId);
}
