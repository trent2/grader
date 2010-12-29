package org.mpg.grader.internals.data;

import org.mpg.grader.data.CriterionDAO;
import org.mpg.grader.entities.Criterion;

public class CriteriaDAOImpl extends NumericIdDAOImpl<Criterion> implements CriterionDAO {
	public CriteriaDAOImpl() {
		super(Criterion.class);
	}

}
