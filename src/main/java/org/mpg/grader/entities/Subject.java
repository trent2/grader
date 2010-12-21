package org.mpg.grader.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.apache.tapestry5.beaneditor.Validate;

@Entity
public class Subject {

    @Id
    @Validate("required")
	private String subjectName;

    @ManyToMany(mappedBy="subjects")
    private List<Teacher> teachers;

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

	public List<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}
}
