package org.mpg.grader.pages.teacher;

import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;
import org.mpg.grader.entities.Teacher;
import org.mpg.grader.pages.Teachers;

public class CreateFromListTeacher {

	@Property
	private String teacherList;

	@Inject
	private Session session;

    @InjectPage
    private Teachers teachers;

    @CommitAfter
    Teachers onSuccess()
    {
    	String[] teacherArray = teacherList.split(";");
    	for(String teacher : teacherArray) {
    		Teacher t = new Teacher();
    		t.setLastName(teacher.trim());
    		session.persist(t);
    	}

        return teachers;
    }
}
