package org.mpg.grader.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.apache.tapestry5.beaneditor.NonVisual;
import org.apache.tapestry5.beaneditor.Validate;

@Entity
public class Pupil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonVisual
    private Long id;

    @Validate("required, maxlength=30")
    @Column(length = 30, nullable = false)
	private String lastName;

    @Validate("required, maxlength=30")
    @Column(length = 30, nullable = false)
	private String firstName;

	@ManyToMany(mappedBy="pupils")
	private Set<PupilGroup> pupilGroups;

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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Set<PupilGroup> getPupilGroups() {
		return pupilGroups;
	}

	@Override
	public String toString() {
		return lastName + ", " + firstName;
	}
}