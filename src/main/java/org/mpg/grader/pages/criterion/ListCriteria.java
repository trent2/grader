package org.mpg.grader.pages.criterion;

import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.grid.GridDataSource;
import org.apache.tapestry5.hibernate.HibernateGridDataSource;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;
import org.mpg.grader.data.CriterionDAO;
import org.mpg.grader.entities.Criterion;

public class ListCriteria {
	@Property
	private Criterion criterion;

	@Inject
	private CriterionDAO criterionDAO;

	@Inject
	private Session session;

	public GridDataSource getCriteria() {
		return new HibernateGridDataSource(session, Criterion.class);
	}

	public Class<Criterion> getCriterionClass() {
		return Criterion.class;
	}

	public void onActionFromDeleteCriterion(Criterion crit) {
		criterionDAO.delete(crit);
	}
}
