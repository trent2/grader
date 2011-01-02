package org.mpg.grader.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.apache.tapestry5.beaneditor.NonVisual;
import org.apache.tapestry5.beaneditor.Validate;

@Entity
public class Period {

	public enum SchoolTerm { Erste_Konferenz, Zweite_Konferenz, Dritte_Konferenz };

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonVisual
    private Long id;

    @Validate("required, regexp, maxlength=9")
    @Column(length=9, nullable=false)
    private String year;

    @Validate("required")
    private SchoolTerm schoolTerm;

    public Period() {
    	year = "2010/2011";
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public SchoolTerm getSchoolTerm() {
		return schoolTerm;
	}

	public void setSchoolTerm(SchoolTerm schoolTerm) {
		this.schoolTerm = schoolTerm;
	}
}
