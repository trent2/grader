package org.mpg.grader.internals.data;

import org.mpg.grader.data.PeriodDAO;
import org.mpg.grader.entities.Period;

public class PeriodDAOImpl extends BasicDAOImpl<Period> implements PeriodDAO {
	public PeriodDAOImpl() {
		super(Period.class);
	}
}