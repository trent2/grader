package org.mpg.grader.data;


public interface StringIdDAO<T> extends BasicDAO<T> {
	public T findById(String id);
}
