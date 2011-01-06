package org.mpg.grader.internals.data;

import org.mpg.grader.data.SubjectDAO;
import org.mpg.grader.entities.Subject;

public class SubjectDAOImpl extends BasicDAOImpl<Subject> implements SubjectDAO {
	public SubjectDAOImpl() {
		super(Subject.class);
	}
}