package org.mpg.grader.internals.data;

import java.io.Serializable;
import java.util.List;

import org.apache.tapestry5.hibernate.HibernateSessionManager;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.mpg.grader.data.BasicDAO;

public abstract class BasicDAOImpl<T> implements BasicDAO<T> {
	@Inject
	HibernateSessionManager hsm;

	Class<T> entityClass;

	protected BasicDAOImpl (Class<T> eC) {
		entityClass = eC;
	}

	@Override
	public void saveOrUpdate(T t) {
		hsm.getSession().saveOrUpdate(t);
	}

	@Override
	public void persist(T t) {
		hsm.getSession().persist(t);
	}

	@Override
	public void delete(T t) {
		hsm.getSession().delete(t);
	}

	@Override
	public List<T> listAll() {
		return hsm.getSession().createCriteria(entityClass).list();
	}

	@Override
	public T findById(Serializable id) {
		return (T)hsm.getSession().get(entityClass, id);
	}
}
