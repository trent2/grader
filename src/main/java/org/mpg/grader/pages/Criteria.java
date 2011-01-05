package org.mpg.grader.pages;

import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.grid.GridDataSource;
import org.apache.tapestry5.hibernate.HibernateGridDataSource;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;
import org.mpg.grader.data.SubjectDAO;
import org.mpg.grader.entities.Subject;

public class Criteria {
	@Inject
	private SubjectDAO subjectDAO;

	@Inject
	private Session session;

	@Property
	private Subject subject;

	public GridDataSource getSubjects() {
		return new HibernateGridDataSource(session, Subject.class);		
	}

	public void onActionFromDeleteSubject(Subject subj) {
		subjectDAO.delete(subj);
	}
}
