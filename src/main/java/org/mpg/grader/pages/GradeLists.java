package org.mpg.grader.pages;

import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.grid.GridDataSource;
import org.apache.tapestry5.hibernate.HibernateGridDataSource;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;
import org.mpg.grader.data.GradeListDAO;
import org.mpg.grader.entities.GradeList;

public class GradeLists {

	@Inject
	private Session session;

	@Inject
	private GradeListDAO gradeListDAO;

	@Property
	private GradeList gradeList;

	public GridDataSource getGradeLists() {
		return new HibernateGridDataSource(session, GradeList.class);
	}

	void onActionFromDelete(GradeList gl) {
		gradeListDAO.delete(gl);
	}
}
