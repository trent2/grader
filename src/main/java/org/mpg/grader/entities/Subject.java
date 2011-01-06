package org.mpg.grader.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.apache.tapestry5.beaneditor.NonVisual;
import org.apache.tapestry5.beaneditor.Validate;

@Entity
public class Subject implements Comparable<Subject> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonVisual
    private Long id;

    @Validate("required")
    @Column(nullable = false)
	private String subjectName;

    public enum FormTypes {Jgst_5, Jgst_6, Jgst_7};

    private FormTypes form;

    @OneToMany
    @Column(nullable = true)
    private List<Criterion> criteria;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public FormTypes getForm() {
		return form;
	}

	public void setForm(FormTypes form) {
		this.form = form;
	}

	public List<Criterion> getCriteria() {
		return criteria;
	}

	public void setCriteria(List<Criterion> criteria) {
		this.criteria = criteria;
	}

	@Override
	public String toString() {
		return subjectName;
	}

	@Override
	public int compareTo(Subject o) {
		return subjectName.compareTo(o.subjectName);
	}
}
