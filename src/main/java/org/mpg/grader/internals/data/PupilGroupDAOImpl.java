package org.mpg.grader.internals.data;

import org.mpg.grader.data.PupilGroupDAO;
import org.mpg.grader.entities.PupilGroup;

public class PupilGroupDAOImpl extends NumericIdDAOImpl<PupilGroup> implements PupilGroupDAO {
	public PupilGroupDAOImpl() {
		super(PupilGroup.class);
	}
}