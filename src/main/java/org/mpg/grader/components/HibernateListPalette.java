package org.mpg.grader.components;

import org.apache.tapestry5.BindingConstants;
import org.apache.tapestry5.SelectModel;
import org.apache.tapestry5.ValueEncoder;
import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.Environmental;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Palette;
import org.apache.tapestry5.hibernate.HibernateSessionSource;
import org.apache.tapestry5.internal.hibernate.HibernateEntityValueEncoder;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.ioc.services.PropertyAccess;
import org.apache.tapestry5.ioc.services.TypeCoercer;
import org.apache.tapestry5.services.PropertyEditContext;
import org.hibernate.Session;
import org.mpg.grader.model.GenericSelectModel;
import org.slf4j.Logger;

public class HibernateListPalette {
	@Environmental
	@Property
	private PropertyEditContext context;

	@Parameter(required = true, allowNull = false, defaultPrefix = BindingConstants.LITERAL)
	@Property
	private String entityClass;

	@Parameter(required = true, defaultPrefix = BindingConstants.LITERAL)
	@Property
	private String entityId;

	@Inject
	private HibernateSessionSource sessionsource;
	
	@Inject
	private Session session;

	@Inject
	private PropertyAccess paccess;

	@Inject
	private TypeCoercer coercer;

	@Inject
	private Logger logger;

	@Component(parameters = { "selected=prop:context.propertyValue",
			"encoder=prop:encoder", "model=prop:listModel",
			"label=prop:context.label"})   //, "clientId=prop:context.propertyId" })
	private Palette listPalette;

	@SuppressWarnings("unchecked")
	public ValueEncoder<?> getEncoder() throws ClassNotFoundException {
		Class<?> eClass = Class.forName(entityClass);
		return new HibernateEntityValueEncoder(eClass, sessionsource
				.getConfiguration().getClassMapping(eClass.getCanonicalName()),
				session, paccess, coercer, logger);
	}

	@SuppressWarnings("unchecked")
	public SelectModel getListModel() {
		return new GenericSelectModel(session.createCriteria(entityClass).list(),
				entityId, paccess);
	}
}
