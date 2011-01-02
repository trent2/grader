package org.mpg.grader.entities;

import java.util.List;

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

    @Column(length = 30)
    @Validate("required, maxlength=30")
	private String lastName;

    @Column(length = 30)
    @Validate("required, maxlength=30")
	private String firstName;

    @ManyToMany
    @Column(nullable = true)
    private List<PupilGroup> pupilGroups;

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

	public List<PupilGroup> getPupilGroups() {
		return pupilGroups;
	}

	public void setPupilGroups(List<PupilGroup> pupilGroups) {
		this.pupilGroups = pupilGroups;
	}

	@Override
	public String toString() {
		return lastName + ", " + firstName;
	}
}