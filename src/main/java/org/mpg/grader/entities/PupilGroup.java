package org.mpg.grader.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.apache.tapestry5.beaneditor.Validate;
import org.mpg.grader.internals.tools.SchoolDate;

@Entity
public class PupilGroup implements Comparable<PupilGroup> {
    @Id
    @Validate("required, maxlength=15")
    @Column(length=15, nullable = false)
    private String mnemonic;

    @Validate("required, regexp, maxlength=9")
    @Column(length=9, nullable=false)
    private String schoolYear;

    @Validate("required, maxlength=80")
    @Column(length=80, nullable = false)
    private String details;

    public PupilGroup() {
    	schoolYear = SchoolDate.getCurrentSchoolYear();
    }

	public String getMnemonic() {
		return mnemonic;
	}

	public void setMnemonic(String mnemonic) {
		this.mnemonic = mnemonic;
	}

	public String getSchoolYear() {
		return schoolYear;
	}

	public void setSchoolYear(String schoolYear) {
		this.schoolYear = schoolYear;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return mnemonic;
	}

	@Override
	public int compareTo(PupilGroup o) {
		return (mnemonic + details).compareTo(o.mnemonic + o.details); 
	}
}