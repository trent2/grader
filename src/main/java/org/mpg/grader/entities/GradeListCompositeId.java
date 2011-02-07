package org.mpg.grader.entities;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class GradeListCompositeId implements Serializable {
	private static final long serialVersionUID = 1L;

	@ManyToOne(optional = false)
	private Period period;

	@ManyToOne(optional = false)
	private Subject subject;

	@ManyToOne(optional = false)
	private PupilGroup pupilGroup;

	@ManyToOne(optional = false)
	private Teacher teacher;

	public Period getPeriod() {
		return period;
	}

	public void setPeriod(Period period) {
		this.period = period;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public PupilGroup getPupilGroup() {
		return pupilGroup;
	}

	public void setPupilGroup(PupilGroup pupilGroup) {
		this.pupilGroup = pupilGroup;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	@Override
	public boolean equals(Object o) {
		GradeListCompositeId igl = (GradeListCompositeId) o;
		if (igl == null)
			return true;
		return igl.period.getId() == period.getId()
				&& igl.subject.getId() == subject.getId()
				&& pupilGroup.getMnemonic()
						.equals(igl.pupilGroup.getMnemonic())
				&& igl.teacher.getId() == teacher.getId();
	}

	@Override
	public int hashCode() {
		return period.getId().hashCode() + subject.getId().hashCode()
				+ teacher.getId().hashCode()
				+ pupilGroup.getMnemonic().hashCode();
	}
}
