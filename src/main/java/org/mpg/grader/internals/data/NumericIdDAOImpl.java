package org.mpg.grader.internals.data;

import java.util.List;

import org.apache.tapestry5.hibernate.HibernateSessionManager;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.mpg.grader.data.NumericIdDAO;

public abstract class NumericIdDAOImpl<T> implements NumericIdDAO<T> {

	@Inject
	HibernateSessionManager hsm;

	private Class<T> entityClass;

	protected NumericIdDAOImpl (Class<T> eC) {
		entityClass = eC;
	}

	@Override
	public void saveOrUpdate(T newSubject) {
		hsm.getSession().saveOrUpdate(newSubject);
	}

	@Override
	public void delete(T subject) {
		hsm.getSession().delete(subject);
	}

	@Override
	public T findById(Long id) {
		return (T)hsm.getSession().load(entityClass, id);
	}

	@Override
	public List<T> listAll() {
		return hsm.getSession().createCriteria(entityClass).list();
	}
}
