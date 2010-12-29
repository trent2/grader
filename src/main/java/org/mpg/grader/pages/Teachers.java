package org.mpg.grader.pages;

import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.grid.GridDataSource;
import org.apache.tapestry5.hibernate.HibernateGridDataSource;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;
import org.mpg.grader.data.TeacherDAO;
import org.mpg.grader.entities.Teacher;
import org.mpg.grader.pages.teacher.CreateTeacher;

public class Teachers {

	@Inject
	private TeacherDAO teacherDAO;

	@Inject
	private Session session;

    @InjectPage
    private CreateTeacher updatePage;

    @Property
    private Teacher teacher;

    public GridDataSource getTeachers() {
		return new HibernateGridDataSource(session, Teacher.class);
    }

    void onActionFromDelete(Teacher t) {
    	teacherDAO.delete(t);
    }

    Object onActionFromUpdate(Teacher t) {
    	updatePage.setTeacher(t);
    	return updatePage;
    }
}
