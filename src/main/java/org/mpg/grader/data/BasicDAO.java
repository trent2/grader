package org.mpg.grader.data;

import java.util.List;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;

public interface BasicDAO<T> {

	public List<T> listAll();

	@CommitAfter
	public void saveOrUpdate(T newTeacher);

	@CommitAfter
	public void delete(T teacher);	
}
