package org.mpg.grader.pages.criterion;

import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.PageActivationContext;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.mpg.grader.data.SubjectDAO;
import org.mpg.grader.entities.Criterion;
import org.mpg.grader.entities.Subject;
import org.mpg.grader.pages.Criteria;

public class CreateSubject {

    @Inject
    private SubjectDAO subjectDAO;

    @InjectPage
    private Criteria criteria;

    @PageActivationContext
    @Property
    private Subject subject;

    public Class<Criterion> getCriterionClass() {
    	return Criterion.class;
    }

    Object onSuccess()
    {
        subjectDAO.saveOrUpdate(subject);

        return criteria;
    }
}