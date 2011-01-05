package org.mpg.grader.pages;

import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.grid.GridDataSource;
import org.apache.tapestry5.hibernate.HibernateGridDataSource;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;
import org.mpg.grader.data.PeriodDAO;
import org.mpg.grader.entities.Period;

public class Periods {

	@Inject
	private PeriodDAO periodDAO;

	@Inject
	private Session session;

    @Property
    private Period period;

    public GridDataSource getPeriods() {
		return new HibernateGridDataSource(session, Period.class);
    }

    void onActionFromDelete(Period p) {
    	periodDAO.delete(p);
    }
}
