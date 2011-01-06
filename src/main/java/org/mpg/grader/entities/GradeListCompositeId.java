package org.mpg.grader.entities;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class GradeListCompositeId implements Serializable {
	private static final long serialVersionUID = 1L;

	@ManyToOne(optional = false)
	Period period;

	@ManyToOne(optional = false)
	Subject subject;

	@ManyToOne(optional = false)
	PupilGroup pupilGroup;

	@ManyToOne(optional = false)
	Teacher teacher;

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
