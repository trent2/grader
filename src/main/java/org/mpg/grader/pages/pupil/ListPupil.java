package org.mpg.grader.pages.pupil;

import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.grid.GridDataSource;
import org.apache.tapestry5.hibernate.HibernateGridDataSource;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;
import org.mpg.grader.data.PupilDAO;
import org.mpg.grader.entities.Pupil;
import org.mpg.grader.entities.PupilGroup;

public class ListPupil {
	@Property
	private Pupil pupil;

	@Inject
	private Session session;

	@Inject
	private PupilDAO pupilDAO;
	
    public GridDataSource getPupils() {
		return new HibernateGridDataSource(session, Pupil.class);
    }

    void onActionFromDelete(Pupil pup) {
    	// remove pupil from all pupil-groups before removing
    	for(PupilGroup pg : pup.getPupilGroups())
    		pg.getPupils().remove(pup);
    	pupilDAO.delete(pup);
    }	
}
