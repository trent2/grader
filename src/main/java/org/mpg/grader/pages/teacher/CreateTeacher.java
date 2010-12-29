package org.mpg.grader.pages.teacher;

import org.apache.tapestry5.annotations.PageActivationContext;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.mpg.grader.data.TeacherDAO;
import org.mpg.grader.entities.Criterion;
import org.mpg.grader.entities.Teacher;
import org.mpg.grader.pages.Teachers;

public class CreateTeacher {

	@PageActivationContext
	@Property(write=false)
	private Teacher teacher;

	@Inject
	private TeacherDAO teacherDAO;

    public Class<Criterion> getCriterionClass() {
    	return Criterion.class;
    }

    public void setTeacher(Teacher t) {
		this.teacher = t;
	}

	Object onSuccess()
    {
        teacherDAO.saveOrUpdate(teacher);

        return Teachers.class;
    }
	
}
