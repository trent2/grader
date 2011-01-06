package org.mpg.grader.internals.data;

import org.mpg.grader.data.CriterionDAO;
import org.mpg.grader.entities.Criterion;

public class CriterionDAOImpl extends BasicDAOImpl<Criterion> implements CriterionDAO {
	public CriterionDAOImpl() {
		super(Criterion.class);
	}
}
