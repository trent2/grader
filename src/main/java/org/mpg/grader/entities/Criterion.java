package org.mpg.grader.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.apache.tapestry5.beaneditor.NonVisual;
import org.apache.tapestry5.beaneditor.Validate;

@Entity
public class Criterion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonVisual
    private Long id;

    @Validate("required")
    @Column(nullable = false)
	private String criterionName;

    @Validate("maxlength=80")
    @Column(length = 80, nullable = false)
    private String shortDescription;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCriterionName() {
		return criterionName;
	}

	public void setCriterionName(String subName) {
		this.criterionName = subName;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	@Override
	public String toString() {
		return criterionName;
	}
}
