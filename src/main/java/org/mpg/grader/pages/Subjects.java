package org.mpg.grader.pages;

import java.util.List;

import org.apache.tapestry5.ioc.annotations.Inject;
import org.mpg.grader.data.SubjectDAO;
import org.mpg.grader.entities.Subject;

public class Subjects {

	@Inject
	private SubjectDAO subjectDAO;

	public List<Subject> getSubjects() {
		return subjectDAO.listAll();
	}
}
