package org.mpg.grader.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.apache.tapestry5.beaneditor.Validate;

@Entity
public class Subject {

    @Id
    @Validate("required")
	private String subjectName;

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subName) {
		this.subjectName = subName;
	}

	@Override
	public String toString() {
		return subjectName;
	}
}
