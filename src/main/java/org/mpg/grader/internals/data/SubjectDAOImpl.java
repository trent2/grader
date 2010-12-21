package org.mpg.grader.internals.data;

import java.util.List;

import org.apache.tapestry5.hibernate.HibernateSessionManager;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.criterion.Restrictions;
import org.mpg.grader.data.SubjectDAO;
import org.mpg.grader.entities.Subject;

public class SubjectDAOImpl implements SubjectDAO {

	@Inject
	HibernateSessionManager hsm;

	@Override
	public void add(Subject newSubject) {
		hsm.getSession().persist(newSubject);
	}

	@Override
	public void delete(Subject subject) {
		hsm.getSession().delete(subject);
	}

	@Override
	public Subject findByName(String name) {
		return (Subject)hsm.getSession().createCriteria(Subject.class).add(Restrictions.eq("subjectName", name)).uniqueResult();
	}

	@Override
	public List<Subject> listAll() {
		return hsm.getSession().createCriteria(Subject.class).list();
	}

	@Override
	public void update(Subject updatedSubject) {
		hsm.getSession().update(updatedSubject);
	}
}
