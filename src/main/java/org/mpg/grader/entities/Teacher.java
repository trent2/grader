package org.mpg.grader.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.apache.tapestry5.beaneditor.NonVisual;
import org.apache.tapestry5.beaneditor.Validate;

@Entity
public class Teacher implements Comparable<Teacher> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonVisual
    private Long id;

    @Validate("required")
    @Column(nullable = false)
	private String lastName;

    @Validate("required, maxlength=10")
    @Column(length=10, nullable = false)
    private String shorty;

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getShorty() {
		return shorty;
	}

	public void setShorty(String shorty) {
		this.shorty = shorty;
	}

	@Override
	public String toString() {
		return shorty;
	}

	@Override
	public int compareTo(Teacher o) {
		return shorty.compareTo(o.shorty);
	}
}
