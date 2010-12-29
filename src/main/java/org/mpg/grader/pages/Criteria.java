package org.mpg.grader.pages;

import java.util.List;

import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.mpg.grader.data.CriterionDAO;
import org.mpg.grader.entities.Criterion;
import org.mpg.grader.pages.criterion.CreateCriterion;

public class Criteria {

	@Inject
	private CriterionDAO criterionDAO;

	@Property
	private Criterion criterion;

	@InjectPage
	private CreateCriterion updateCriterion;

	public List<Criterion> getCriteria() {
		return criterionDAO.listAll();
	}

	public void onActionFromDelete(Criterion crit) {
		criterionDAO.delete(crit);
	}

	public Object onActionFromUpdate(Criterion crit) {
		updateCriterion.setCriterion(crit);
		return updateCriterion;
	}

}
