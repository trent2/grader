package org.mpg.grader.data;

import java.util.List;

import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.mpg.grader.entities.Teacher;

public interface TeacherDAO {
	public Teacher findByName(String name);

	public List<Teacher> listAll();

	@CommitAfter
	public void add(Teacher newTeacher);

	@CommitAfter
	public void update(Teacher updatedTeacher);

	@CommitAfter
	public void delete(Teacher teacher);	
}
