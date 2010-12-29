package org.mpg.grader.internals.data;

import org.mpg.grader.data.TeacherDAO;
import org.mpg.grader.entities.Teacher;

public class TeacherDAOImpl extends NumericIdDAOImpl<Teacher> implements TeacherDAO {
	public TeacherDAOImpl() {
		super(Teacher.class);
	}
}