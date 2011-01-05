package org.mpg.grader.components;

import org.apache.tapestry5.BindingConstants;
import org.apache.tapestry5.annotations.Environmental;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.ioc.services.PropertyAccess;
import org.apache.tapestry5.services.PropertyOutputContext;

public class ListDisplay {
	@Environmental
	@Property
	private PropertyOutputContext context;

	@Parameter(defaultPrefix = BindingConstants.LITERAL)
	private String field; 

	@Inject
	private PropertyAccess paccess;

	public String getTheList() {
		return "Hallo, Eintrag."; // sb.toString();
/*		StringBuilder sb = new StringBuilder();

		for(Object o : (List<?>) context.getPropertyValue()) {
			sb.append(", ");
			PropertyAdapter pa = paccess.getAdapter(o).getPropertyAdapter(field);
			if(pa != null)
				sb.append(pa.get(o));
			else
				sb.append(o);
		}
		sb.delete(0, 2); */
	}
}
