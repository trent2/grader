package org.mpg.grader.pages.pupil;

import java.util.HashSet;
import java.util.Set;

import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.mpg.grader.data.PupilDAO;
import org.mpg.grader.data.PupilGroupDAO;
import org.mpg.grader.entities.Pupil;
import org.mpg.grader.entities.PupilGroup;
import org.mpg.grader.pages.Pupils;

public class CreateFromListPupil {
	@Property
	private String pupilList;

	@Inject
	private PupilDAO pupilDAO;

	@Inject
	private PupilGroupDAO pupilGroupDAO;

	@CommitAfter
    Class<Pupils> onSuccess()
    {
    	for(String pupIt : pupilList.split(";")) {
    		String[] pVal = pupIt.split("\\|");
    		Set<PupilGroup> groupList = new HashSet<PupilGroup>();
    		Pupil pupil = new Pupil();
    		pupil.setLastName(pVal[0].trim());
    		pupil.setFirstName(pVal[1].trim());
    		pupilDAO.persist(pupil);

    		PupilGroup pg = null;
			for(int i=2; i<pVal.length; ++i) {
    			if((pg = pupilGroupDAO.findById(Long.valueOf(pVal[i]))) != null) {
    				pg.getPupils().add(pupil);
    				pupilGroupDAO.persist(pg);
    			}
			}
    	}
    	return Pupils.class;
    }
}
