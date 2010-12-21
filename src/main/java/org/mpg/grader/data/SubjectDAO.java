package org.mpg.grader.data;

import java.util.List;

import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.mpg.grader.entities.Subject;

public interface SubjectDAO {
	public Subject findByName(String name);

	public List<Subject> listAll();

	@CommitAfter
	public void add(Subject newSubject);

	@CommitAfter
	public void update(Subject updatedSubject);

	@CommitAfter
	public void delete(Subject subject);	
}
