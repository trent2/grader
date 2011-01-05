package org.mpg.grader.pages;

import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.grid.GridDataSource;
import org.apache.tapestry5.hibernate.HibernateGridDataSource;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;
import org.mpg.grader.data.TeacherDAO;
import org.mpg.grader.entities.Teacher;

public class Teachers {

	@Inject
	private TeacherDAO teacherDAO;

	@Inject
	private Session session;

	@Property
    private Teacher teacher;

    public GridDataSource getTeachers() {
		return new HibernateGridDataSource(session, Teacher.class);
    }

    void onActionFromDelete(Teacher t) {
    	teacherDAO.delete(t);
    }
}
