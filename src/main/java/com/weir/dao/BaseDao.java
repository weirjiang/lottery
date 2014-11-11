package com.weir.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

public abstract class BaseDao<T> {
	protected EntityManager em;
    @PersistenceContext
    public void setEm(EntityManager em) {
        this.em = em;
    }
    private Class<T> entityClass;

    @SuppressWarnings("unchecked")
    public BaseDao() {
        Class<?> subClass = this.getClass();
        Class<?> parentClass = null;
        do {
            parentClass = subClass.getSuperclass();
            if (parentClass.equals(BaseDao.class)) {
                this.entityClass = (Class<T>) ((ParameterizedType) subClass.getGenericSuperclass()).getActualTypeArguments()[0];
                break;
            }

            subClass = parentClass;
        } while (!parentClass.equals(Object.class));

    }
    @SuppressWarnings("unchecked")
    public List<T> findAll(String hql, int offset, int fetchSize, Object... params) {
        Query query = em.createQuery(hql);
        if (params != null) {
            for (int i = 0; i < params.length; i++) {
                query.setParameter(i + 1, params[i]);
            }
        }
        query.setFirstResult(offset);
        query.setMaxResults(fetchSize);

        return query.getResultList();
    }

    public int getTotalSize(String hql, Object... params) {
        Query query = em.createQuery(hql);
        if (params != null) {
            for (int i = 0; i < params.length; i++) {
                query.setParameter(i + 1, params[i]);
            }
        }
        return ((Long) query.getSingleResult()).intValue();
    }

    public T findOne(String id) {
        return em.find(entityClass, id);
    }
    public T findOne(Integer id) {
        return em.find(entityClass, id);
    }
    @Transactional
    public void save(T entity) {
    	em.persist(entity);
    }
    
    @Transactional
    public void batchsave(List<T> entitys) {
        if (entitys == null || entitys.isEmpty()) {
            return;
        }

        for (T entity : entitys) {
            em.persist(entity);
        }
    }

    @Transactional
    public T update(T entity) {
        em.merge(entity);
        return entity;
    }

    @Transactional
    public void delete(T entity) {
        em.remove(entity);
    }

}
