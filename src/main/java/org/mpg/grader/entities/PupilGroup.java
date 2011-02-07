package org.mpg.grader.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.apache.tapestry5.beaneditor.NonVisual;
import org.apache.tapestry5.beaneditor.Validate;
import org.mpg.grader.internals.tools.SchoolDate;

@Entity
public class PupilGroup implements Comparable<PupilGroup> {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonVisual
    private Long id;

    @Validate("required, maxlength=15")
    @Column(length=15, nullable = false)
    private String mnemonic;

    @Validate("required, regexp, maxlength=9")
    @Column(length=9, nullable=false)
    private String schoolYear;

    @Validate("required, maxlength=80")
    @Column(length=80, nullable = false)
    private String details;

    @Column(nullable = false)
    private boolean mainPupilGroup;

    @ManyToMany(cascade={CascadeType.PERSIST})
    private Set<Pupil> pupils;

    public PupilGroup() {
    	schoolYear = SchoolDate.getCurrentSchoolYear();
    }

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public boolean isMainPupilGroup() {
		return mainPupilGroup;
	}

	public void setMainPupilGroup(boolean mainPupilGroup) {
		this.mainPupilGroup = mainPupilGroup;
	}

	public Set<Pupil> getPupils() {
		return pupils;
	}

	public void setPupils(Set<Pupil> pupils) {
		this.pupils = pupils;
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