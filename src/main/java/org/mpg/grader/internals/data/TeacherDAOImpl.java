package org.mpg.grader.internals.data;

import java.util.List;

import org.apache.tapestry5.hibernate.HibernateSessionManager;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.criterion.Restrictions;
import org.mpg.grader.data.TeacherDAO;
import org.mpg.grader.entities.Teacher;

public class TeacherDAOImpl implements TeacherDAO {

	@Inject
	HibernateSessionManager hsm;

	@Override
	public void add(Teacher newTeacher) {
		hsm.getSession().persist(newTeacher);
	}

	@Override
	public void delete(Teacher teacher) {
		hsm.getSession().delete(teacher);
	}

	@Override
	public Teacher findByName(String name) {
		return (Teacher)hsm.getSession().createCriteria(Teacher.class).add(Restrictions.eq("lastName", name)).uniqueResult();
	}

	@Override
	public List<Teacher> listAll() {
		return hsm.getSession().createCriteria(Teacher.class).list();
	}

	@Override
	public void update(Teacher updatedTeacher) {
		hsm.getSession().update(updatedTeacher);
	}


}
