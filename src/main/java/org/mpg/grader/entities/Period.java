package org.mpg.grader.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.apache.tapestry5.beaneditor.NonVisual;
import org.apache.tapestry5.beaneditor.Validate;
import org.mpg.grader.internals.tools.SchoolDate;

@Entity
public class Period implements Comparable<Period> {
	public enum SchoolTerm {
		 Erste_Konferenz, Zweite_Konferenz, Dritte_Konferenz
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonVisual
    private Long id;

    @Validate("required, regexp, maxlength=9")
    @Column(length=9, nullable=false)
    private String schoolYear;

    @Validate("required")
    @Column(nullable = false)
    private SchoolTerm schoolTerm;

    public Period() {
    	schoolYear = SchoolDate.getCurrentSchoolYear();
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSchoolYear() {
		return schoolYear;
	}

	public void setSchoolYear(String schoolYear) {
		this.schoolYear = schoolYear;
	}

	public SchoolTerm getSchoolTerm() {
		return schoolTerm;
	}

	public void setSchoolTerm(SchoolTerm schoolTerm) {
		this.schoolTerm = schoolTerm;
	}

	@Override
	public String toString() {
		return schoolYear;
	}

	@Override
	public int compareTo(Period o) {
		return (schoolYear + schoolTerm).compareTo(o.schoolYear + o.schoolTerm);
	}
}