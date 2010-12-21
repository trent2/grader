package org.mpg.grader.pages.teacher;

import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.mpg.grader.data.TeacherDAO;
import org.mpg.grader.entities.Teacher;
import org.mpg.grader.pages.Teachers;

public class CreateFromListTeacher {

	@Property
	private String teacherList;

	@Inject
	private TeacherDAO teacherDAO;

    @InjectPage
    private Teachers teachers;

    Teachers onSuccess()
    {
    	String[] teacherArray = teacherList.split(";");
    	for(String teacher : teacherArray) {
    		Teacher t = new Teacher();
    		t.setLastName(teacher.trim());
    		teacherDAO.add(t);
    	}

        return teachers;
    }
}
