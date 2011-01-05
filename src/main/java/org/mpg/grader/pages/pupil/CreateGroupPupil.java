package org.mpg.grader.pages.pupil;

import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.mpg.grader.data.PupilGroupDAO;
import org.mpg.grader.entities.PupilGroup;
import org.mpg.grader.pages.Pupils;

public class CreateGroupPupil {
	@Property(write=false)
	private PupilGroup pupilGroup;

	@Inject
	private PupilGroupDAO pupilGroupDAO;

    public void setPupilGroup(PupilGroup pg) {
		this.pupilGroup = pg;
	}

	Object onSuccess()
    {
        pupilGroupDAO.saveOrUpdate(pupilGroup);

        return Pupils.class;
    }
}
