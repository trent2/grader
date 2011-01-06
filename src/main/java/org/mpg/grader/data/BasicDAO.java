package org.mpg.grader.data;

import java.io.Serializable;
import java.util.List;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;

public interface BasicDAO<T> {

	public List<T> listAll();

	@CommitAfter
	public void saveOrUpdate(T newT);

	@CommitAfter
	public void delete(T t);

	public T findById(Serializable id);	
}
