package org.mpg.grader.entities;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.apache.tapestry5.beaneditor.Validate;

@Entity
public class Teacher {

    @Id
    @Validate("required")
	private String lastName;

    @OneToMany
    @Column(nullable = true)
    private List<Subject> subjects;

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

	@Override
	public String toString() {
		return lastName;
	}
}
