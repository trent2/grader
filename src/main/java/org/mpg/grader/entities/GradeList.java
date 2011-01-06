package org.mpg.grader.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

@Entity
public class GradeList {
	@EmbeddedId
	private GradeListCompositeId gradeListId;

	@MapsId("period")
	@OneToOne
	private Period period;

	@MapsId("subject")
	@OneToOne
	private Subject subject;

	@MapsId("pupilGroup")
	@OneToOne
	private PupilGroup pupilGroup;
	
	@MapsId("teacher")
	@OneToOne
	private Teacher teacher;

	public GradeList() {
		gradeListId = new GradeListCompositeId();
	}
	public GradeListCompositeId getGradeListId() {
		return gradeListId;
	}
	public void setGradeListId(GradeListCompositeId gradeListId) {
		this.gradeListId = gradeListId;
	}

	public Period getPeriod() {
		return period;
	}

	public Subject getSubject() {
		return subject;
	}

	public PupilGroup getPupilGroup() {
		return pupilGroup;
	}

	public Teacher getTeacher() {
		return teacher;
	}
}
