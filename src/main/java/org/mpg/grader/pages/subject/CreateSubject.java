package org.mpg.grader.pages.subject;

import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.mpg.grader.data.SubjectDAO;
import org.mpg.grader.entities.Subject;
import org.mpg.grader.pages.Subjects;

public class CreateSubject {

    @Inject
    private SubjectDAO subjectDAO;

    @InjectPage
    private Subjects subjects;

    @Property
    private Subject subject;

    Object onSuccess()
    {
        subjectDAO.add(subject);

        return subjects;
    }
	
}
