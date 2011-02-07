package org.mpg.grader.pages.criterion;

import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.PageActivationContext;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.mpg.grader.data.CriterionDAO;
import org.mpg.grader.entities.Criterion;
import org.mpg.grader.pages.Criteria;

public class CreateCriterion {

    @Inject
    private CriterionDAO criterionDAO;

    @InjectPage
    private Criteria criteria;

    @PageActivationContext
    @Property
    private Criterion criterion;

    @CommitAfter
	Object onSuccess()
    {
        criterionDAO.saveOrUpdate(criterion);

        return criteria;
    }
}