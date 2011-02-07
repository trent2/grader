package org.mpg.grader.pages;

import org.apache.tapestry5.annotations.Environmental;
import org.apache.tapestry5.services.PropertyOutputContext;
import org.mpg.grader.entities.Period;
import org.mpg.grader.entities.PupilGroup;
import org.mpg.grader.entities.Subject;
import org.mpg.grader.entities.Teacher;

public class AppPropertyDisplayBlocks {
	@Environmental
	private PropertyOutputContext context;
	
	public String getPeriodDesc() {
		Period p = (Period)context.getPropertyValue();
		return p.getSchoolYear() + ", " + p.getSchoolTerm();
	}

	public String getSubjectName() {
		Subject s = (Subject)context.getPropertyValue();
		return s.getSubjectName() + ", " + s.getForm();
	}
	
	public String getTeacherShorty() {
		Teacher t = (Teacher)context.getPropertyValue();
		return t.getShorty();
	}

	public String getPupilGroupDesc() {
		PupilGroup p = (PupilGroup)context.getPropertyValue();
		return p.getMnemonic() + ", " + p.getDetails();
	}
}
