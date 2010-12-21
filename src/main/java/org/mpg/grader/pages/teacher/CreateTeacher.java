package org.mpg.grader.pages.teacher;

import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.mpg.grader.data.TeacherDAO;
import org.mpg.grader.entities.Subject;
import org.mpg.grader.entities.Teacher;
import org.mpg.grader.pages.Teachers;

public class CreateTeacher {

	@Property
	private Teacher teacher;

	@Inject
	private TeacherDAO teacherDAO;

    @InjectPage
    private Teachers teachers;

    public Class<Subject> getSubjectClass() {
    	return Subject.class;
    }

    Object onSuccess()
    {
        teacherDAO.add(teacher);

        return teachers;
    }
	
}
