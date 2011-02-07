package org.mpg.grader.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import org.apache.tapestry5.beaneditor.Validate;

@Entity
public class GradeList {
	@EmbeddedId
	private GradeListCompositeId gradeListId;

	public GradeList() {
		gradeListId = new GradeListCompositeId();
	}
	public GradeListCompositeId getGradeListId() {
		return gradeListId;
	}
	public void setGradeListId(GradeListCompositeId gradeListId) {
		this.gradeListId = gradeListId;
	}

	@Validate("required")
	public Period getPeriod() {
		return gradeListId.getPeriod();
	}

	public void setPeriod(Period period) {
		gradeListId.setPeriod(period);
	}

	@Validate("required")
	public Subject getSubject() {
		return gradeListId.getSubject();
	}

	public void setSubject(Subject subject) {
		gradeListId.setSubject(subject);
	}
	
	@Validate("required")
	public PupilGroup getPupilGroup() {
		return gradeListId.getPupilGroup();
	}

	public void setPupilGroup(PupilGroup pupilGroup) {
		gradeListId.setPupilGroup(pupilGroup);
	}

	@Validate("required")
	public Teacher getTeacher() {
		return gradeListId.getTeacher();
	}

	public void setTeacher(Teacher teacher) {
		gradeListId.setTeacher(teacher);
	}
}