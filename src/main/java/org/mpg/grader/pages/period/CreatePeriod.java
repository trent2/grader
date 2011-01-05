package org.mpg.grader.pages.period;

import org.apache.tapestry5.annotations.PageActivationContext;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.BeanModelSource;
import org.mpg.grader.data.PeriodDAO;
import org.mpg.grader.entities.Period;
import org.mpg.grader.pages.Periods;

public class CreatePeriod {
	@PageActivationContext
	@Property
	private Period period;

	@Inject
	private PeriodDAO periodDAO;

	private BeanModelSource beanModelSource;

	Object onSuccess()
    {
        periodDAO.saveOrUpdate(period);

        return Periods.class;
    }
}
