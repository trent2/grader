package org.mpg.grader.pages.pupil;

import org.apache.tapestry5.annotations.PageActivationContext;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.mpg.grader.data.PupilDAO;
import org.mpg.grader.entities.Pupil;
import org.mpg.grader.entities.PupilGroup;
import org.mpg.grader.pages.Pupils;

public class CreatePupil {
	@PageActivationContext
	@Property
	private Pupil pupil;

	@Inject
	private PupilDAO pupilDAO;

    public Class<PupilGroup> getPupilGroupClass() {
    	return PupilGroup.class;
    }

	Object onSuccess()
    {
        pupilDAO.saveOrUpdate(pupil);
        return Pupils.class;
    }
}
