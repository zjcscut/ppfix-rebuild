package com.ppfix.web.dao.impl;

/**
 * created by IntelliJ IDEA
 *
 * @author zjc
 * @time 2015/10/30-17:23
 */


import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.ppfix.web.dao.BaseDAO;
import org.apache.ibatis.session.SqlSessionFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.StatelessSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Component("baseDAO")
@SuppressWarnings("all")
public abstract class BaseDAOImpl<T> implements BaseDAO<T> {


    /**
     * hibernate入口
     */
    @Resource(name = "sessionFactory")
    protected SessionFactory hibernateSessionFactory;

//    /**
//     * mybatis入口
//     */
//    @Resource(name = "sqlSessionFactory")
//    protected SqlSessionFactory mybatisSessionFactory;

    protected Session getCurrentSession() {
        return hibernateSessionFactory.getCurrentSession();
    }

    public Integer save(T o) {
        return (int)this.getCurrentSession().save(o);
    }

    public void delete(T o) {
        this.getCurrentSession().delete(o);
    }

    public void update(T o) {
        this.getCurrentSession().update(o);
    }

    public void saveOrUpdate(T o) {
        this.getCurrentSession().saveOrUpdate(o);
    }

    public List<T> find(String hql) {
        return this.getCurrentSession().createQuery(hql).list();
    }

    public List<T> find(String hql, Map<String , Object> param) {
        Query q = this.getCurrentSession().createQuery(hql);
        Set<String> keySet=param.keySet();
        for(String key:keySet){
           q.setParameter(key,param.get(key));
        }
        return q.list();
    }


    public List<T> find(String hql, Map<String , Object> param, Integer page, Integer rows) {
        if (page == null || page < 1) {
            page = 1;
        }
        if (rows == null || rows < 1) {
            rows = 10;
        }
        Query q = this.getCurrentSession().createQuery(hql);

        Set<String> keySet=param.keySet();
        for(String key:keySet){
            q.setParameter(key,param.get(key));
        }
        return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
    }



    public T get(Class<T> c, Serializable id) {
        return (T) this.getCurrentSession().get(c, id);
    }

    public T get(String hql, Map<String , Object> param) {
        List<T> l = this.find(hql, param);
        if (l != null && l.size() > 0) {
            return l.get(0);
        } else {
            return null;
        }
    }


    public Long count(String hql) {
        return (Long) this.getCurrentSession().createQuery(hql).uniqueResult();
    }

    public Long count(String hql,Map<String , Object> param) {
        Query q = this.getCurrentSession().createQuery(hql);
        Set<String> keySet=param.keySet();
        for(String key:keySet){
            q.setParameter(key,param.get(key));
        }
        return (Long) q.uniqueResult();
    }



    public Integer executeHql(String hql) {
        return this.getCurrentSession().createQuery(hql).executeUpdate();
    }

    public Integer executeHql(String hql, Map<String , Object> param) {
        Query q = this.getCurrentSession().createQuery(hql);
        Set<String> keySet=param.keySet();
        for(String key:keySet){
            q.setParameter(key,param.get(key));
        }
        return q.executeUpdate();
    }



}