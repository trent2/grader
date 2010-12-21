package org.mpg.grader.pages;

import java.util.List;

import org.apache.tapestry5.ioc.annotations.Inject;
import org.mpg.grader.data.TeacherDAO;
import org.mpg.grader.entities.Teacher;

public class Teachers {

	@Inject
	private TeacherDAO teacherDAO;

    public List<Teacher> getTeachers() {
		return teacherDAO.listAll();
    }
}
