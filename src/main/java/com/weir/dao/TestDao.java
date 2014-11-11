package com.weir.dao;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.weir.entiy.User;

@Repository
public class TestDao{
	protected EntityManager em;
    @PersistenceContext
    public void setEm(EntityManager em) {
        this.em = em;
    }
	public User getUserById(Integer userId){
		Query query = em.createQuery("from User u where u.userId = :userId ");
		query.setParameter("userId", userId);
		List list = query.getResultList();
		Iterator<User> it = list.iterator();
		User user = new User();
		if(it.hasNext()){
			user = (User)it.next();
		}
		return user;
	}
}
