package org.mpg.grader.internals.data;

import org.mpg.grader.data.PupilDAO;
import org.mpg.grader.entities.Pupil;

public class PupilDAOImpl extends BasicDAOImpl<Pupil> implements PupilDAO {
	public PupilDAOImpl() {
		super(Pupil.class);
	}
}