package org.mpg.grader.components;

import org.apache.tapestry5.BindingConstants;
import org.apache.tapestry5.FieldValidator;
import org.apache.tapestry5.SelectModel;
import org.apache.tapestry5.ValueEncoder;
import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.Environmental;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Select;
import org.apache.tapestry5.hibernate.HibernateSessionSource;
import org.apache.tapestry5.internal.hibernate.HibernateEntityValueEncoder;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.ioc.services.PropertyAccess;
import org.apache.tapestry5.ioc.services.TypeCoercer;
import org.apache.tapestry5.services.PropertyEditContext;
import org.hibernate.Session;
import org.mpg.grader.model.GenericSelectModel;
import org.slf4j.Logger;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class HibernateSelectList {
	@Environmental
	@Property
	private PropertyEditContext context;

	@Parameter(required = true, allowNull = false)
	@Property
	private Class<?> entityClass;

	@Parameter(defaultPrefix = BindingConstants.LITERAL)
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

	@Component(parameters = { "value=prop:context.propertyValue",
			"encoder=prop:encoder", "model=prop:listModel",
			"label=prop:context.label", "validate=prop:selectListValidator"})
	private Select selectList;

	public ValueEncoder<?> getEncoder() {
		return new HibernateEntityValueEncoder(entityClass, sessionsource
				.getConfiguration().getClassMapping(entityClass.getCanonicalName()),
				session, paccess, coercer, logger);
	}

	public FieldValidator<?> getSelectListValidator() {
		return context.getValidator(selectList);
	}

	public SelectModel getListModel() {
		return new GenericSelectModel(session.createCriteria(entityClass).list(),
				entityId, paccess);
	}
}
