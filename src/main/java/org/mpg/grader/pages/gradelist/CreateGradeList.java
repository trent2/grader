package org.mpg.grader.pages.gradelist;

import org.apache.tapestry5.annotations.PageActivationContext;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.mpg.grader.data.GradeListDAO;
import org.mpg.grader.entities.GradeList;
import org.mpg.grader.entities.Period;
import org.mpg.grader.entities.PupilGroup;
import org.mpg.grader.entities.Subject;
import org.mpg.grader.entities.Teacher;
import org.mpg.grader.pages.GradeLists;

public class CreateGradeList {

	@PageActivationContext
	@Property
	private GradeList gradeList;

	@Inject
	private GradeListDAO gradeListDAO;

	public Class<Period> getPeriodClass() {
		return Period.class;
	}

	public Class<PupilGroup> getPupilGroupClass() {
		return PupilGroup.class;
	}

	public Class<Subject> getSubjectClass() {
		return Subject.class;
	}

	public Class<Teacher> getTeacherClass() {
		return Teacher.class;
	}

	Object onSuccess()
    {
		gradeListDAO.saveOrUpdate(gradeList);

        return GradeLists.class;
    }
}
