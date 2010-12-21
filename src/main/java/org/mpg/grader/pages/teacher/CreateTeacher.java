package org.mpg.grader.pages.teacher;

import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.mpg.grader.data.TeacherDAO;
import org.mpg.grader.entities.Teacher;
import org.mpg.grader.pages.Teachers;

public class CreateTeacher {

	@Property
	private Teacher teacher;

	@Inject
	private TeacherDAO teacherDAO;

	/*
    @Inject
    private HibernateSessionSource sessionsource;

	@Inject
	private PropertyAccess paccess;

	@Inject
	private TypeCoercer coercer;

	@Inject
	private Logger logger;

	@Inject
    private Session session;

	@Inject
	private TeacherDAO teacherDAO;

    @Property
	private ValueEncoder<Subject> encoder = new HibernateEntityValueEncoder<Subject>(
			Subject.class, sessionsource.getConfiguration().getClassMapping(Subject.class.getCanonicalName()),
			session, paccess, coercer, logger);

    @Property
	private SelectModel model = new GenericSelectModel<Subject>(session.createCriteria(Subject.class).list(), "subjectName", paccess);
*/
    @InjectPage
    private Teachers teachers;

    Object onSuccess()
    {
        teacherDAO.add(teacher);

        return teachers;
    }
	
}
