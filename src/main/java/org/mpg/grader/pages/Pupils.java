package org.mpg.grader.pages;

import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.grid.GridDataSource;
import org.apache.tapestry5.hibernate.HibernateGridDataSource;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;
import org.mpg.grader.data.PupilGroupDAO;
import org.mpg.grader.entities.PupilGroup;

public class Pupils {

	@Inject
	private PupilGroupDAO pupilGroupDAO;

	@Inject
	private Session session;

    @Property
    private PupilGroup pupilGroup;

    public GridDataSource getPupilGroups() {
		return new HibernateGridDataSource(session, PupilGroup.class);
    }

    void onActionFromDelete(PupilGroup pg) {
    	pupilGroupDAO.delete(pg);
    }	
}
