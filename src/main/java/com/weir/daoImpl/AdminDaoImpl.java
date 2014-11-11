package com.weir.daoImpl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.weir.dao.BaseDao;
import com.weir.dao.IAdminDao;
import com.weir.entiy.Admin;
@Repository
public class AdminDaoImpl extends BaseDao<Admin> implements IAdminDao{

	@Override
	public List getAdmin() {
		// TODO Auto-generated method stub
		Query query = em.createQuery("from Admin");
		List list = query.getResultList();
		return list;
	}
	
}
