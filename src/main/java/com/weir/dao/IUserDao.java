package com.weir.dao;

import com.weir.entiy.User;

public interface IUserDao {
	public User getUserById(Integer user_id);	
	public int getLotteryCount(Integer userId,String time);
	
}
