package org.mpg.grader.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.tapestry5.SymbolConstants;
import org.apache.tapestry5.hibernate.HibernateTransactionAdvisor;
import org.apache.tapestry5.ioc.Configuration;
import org.apache.tapestry5.ioc.MappedConfiguration;
import org.apache.tapestry5.ioc.MethodAdviceReceiver;
import org.apache.tapestry5.ioc.OrderedConfiguration;
import org.apache.tapestry5.ioc.ServiceBinder;
import org.apache.tapestry5.ioc.annotations.Local;
import org.apache.tapestry5.ioc.annotations.Match;
import org.apache.tapestry5.ioc.services.Coercion;
import org.apache.tapestry5.ioc.services.CoercionTuple;
import org.apache.tapestry5.services.BeanBlockContribution;
import org.apache.tapestry5.services.DisplayBlockContribution;
import org.apache.tapestry5.services.Request;
import org.apache.tapestry5.services.RequestFilter;
import org.apache.tapestry5.services.RequestHandler;
import org.apache.tapestry5.services.Response;
import org.mpg.grader.data.CriterionDAO;
import org.mpg.grader.data.GradeListDAO;
import org.mpg.grader.data.PeriodDAO;
import org.mpg.grader.data.PupilDAO;
import org.mpg.grader.data.PupilGroupDAO;
import org.mpg.grader.data.SubjectDAO;
import org.mpg.grader.data.TeacherDAO;
import org.mpg.grader.entities.Period;
import org.mpg.grader.entities.PupilGroup;
import org.mpg.grader.entities.Subject;
import org.mpg.grader.entities.Teacher;
import org.mpg.grader.internals.data.CriterionDAOImpl;
import org.mpg.grader.internals.data.GradeListDAOImpl;
import org.mpg.grader.internals.data.PeriodDAOImpl;
import org.mpg.grader.internals.data.PupilDAOImpl;
import org.mpg.grader.internals.data.PupilGroupDAOImpl;
import org.mpg.grader.internals.data.SubjectDAOImpl;
import org.mpg.grader.internals.data.TeacherDAOImpl;
import org.slf4j.Logger;

/**
 * This module is automatically included as part of the Tapestry IoC Registry, it's a good place to
 * configure and extend Tapestry, or to place your own service definitions.
 */
public class AppModule
{
    public static void bind(ServiceBinder binder)
    {
        // binder.bind(MyServiceInterface.class, MyServiceImpl.class);
    	
    	binder.bind(TeacherDAO.class, TeacherDAOImpl.class);
    	binder.bind(CriterionDAO.class, CriterionDAOImpl.class);
    	binder.bind(PupilDAO.class, PupilDAOImpl.class);
    	binder.bind(PupilGroupDAO.class, PupilGroupDAOImpl.class);
    	binder.bind(SubjectDAO.class, SubjectDAOImpl.class);
    	binder.bind(PeriodDAO.class, PeriodDAOImpl.class);
    	binder.bind(GradeListDAO.class, GradeListDAOImpl.class);

        // Make bind() calls on the binder object to define most IoC services.
        // Use service builder methods (example below) when the implementation
        // is provided inline, or requires more initialization than simply
        // invoking the constructor.
    }
    
    @SuppressWarnings("unchecked")
	public static void  contributeDefaultDataTypeAnalyzer(MappedConfiguration<Class<?>, String> configuration)
    {
    	configuration.add(List.class, "list");
    	configuration.add(Set.class, "set");
    	configuration.add(Teacher.class, "teacher");
    	configuration.add(PupilGroup.class, "pupilGroup");
    	configuration.add(Subject.class, "subject");
    	configuration.add(Period.class, "period");
    }

    public static void contributeBeanBlockSource(Configuration<BeanBlockContribution> configuration)
    {
      configuration.add(new DisplayBlockContribution("teacher", "AppPropertyDisplayBlocks", "teacherBlock"));
      configuration.add(new DisplayBlockContribution("pupilGroup", "AppPropertyDisplayBlocks", "pupilGroupBlock"));
      configuration.add(new DisplayBlockContribution("subject", "AppPropertyDisplayBlocks", "subjectBlock"));
      configuration.add(new DisplayBlockContribution("period", "AppPropertyDisplayBlocks", "periodBlock"));
//    	configuration.add(new EditBlockContribution("Teacher", "AppPropertyEditBlocks", "tBlock"));
    }


    @Match("*DAO")
    public static void adviseTransactions(HibernateTransactionAdvisor advisor, MethodAdviceReceiver receiver)
    {
        advisor.addTransactionCommitAdvice(receiver);
    }

    public static void contributeApplicationDefaults(
            MappedConfiguration<String, String> configuration)
    {
        // Contributions to ApplicationDefaults will override any contributions to
        // FactoryDefaults (with the same key). Here we're restricting the supported
        // locales to just "en" (English). As you add localised message catalogs and other assets,
        // you can extend this list of locales (it's a comma separated series of locale names;
        // the first locale name is the default when there's no reasonable match).
        
        configuration.add(SymbolConstants.SUPPORTED_LOCALES, "de");

        // The factory default is true but during the early stages of an application
        // overriding to false is a good idea. In addition, this is often overridden
        // on the command line as -Dtapestry.production-mode=false
        configuration.add(SymbolConstants.PRODUCTION_MODE, "false");

        // The application version number is incorprated into URLs for some
        // assets. Web browsers will cache assets because of the far future expires
        // header. If existing assets are changed, the version number should also
        // change, to force the browser to download new versions.
        configuration.add(SymbolConstants.APPLICATION_VERSION, "0.1");
    }
    

    /**
     * This is a service definition, the service will be named "TimingFilter". The interface,
     * RequestFilter, is used within the RequestHandler service pipeline, which is built from the
     * RequestHandler service configuration. Tapestry IoC is responsible for passing in an
     * appropriate Logger instance. Requests for static resources are handled at a higher level, so
     * this filter will only be invoked for Tapestry related requests.
     * 
     * <p>
     * Service builder methods are useful when the implementation is inline as an inner class
     * (as here) or require some other kind of special initialization. In most cases,
     * use the static bind() method instead. 
     * 
     * <p>
     * If this method was named "build", then the service id would be taken from the 
     * service interface and would be "RequestFilter".  Since Tapestry already defines
     * a service named "RequestFilter" we use an explicit service id that we can reference
     * inside the contribution method.
     */    
    public RequestFilter buildTimingFilter(final Logger log)
    {
        return new RequestFilter()
        {
            @Override
			public boolean service(Request request, Response response, RequestHandler handler)
                    throws IOException
            {
                long startTime = System.currentTimeMillis();

                try
                {
                    // The responsibility of a filter is to invoke the corresponding method
                    // in the handler. When you chain multiple filters together, each filter
                    // received a handler that is a bridge to the next filter.
                    
                    return handler.service(request, response);
                }
                finally
                {
                    long elapsed = System.currentTimeMillis() - startTime;

                    log.info(String.format("Request time: %d ms", elapsed));
                }
            }
        }    ;
    }

	@SuppressWarnings("rawtypes")
	public static void contributeTypeCoercer(
			Configuration<CoercionTuple> configuration) {
		Coercion<List, Set> listSetCoercion = new Coercion<List, Set>() {
			@Override
			public Set coerce(List input) {
				return new HashSet(input);
			}
		};
		Coercion<Set, List> setListCoercion = new Coercion<Set, List>() {
			@Override
			public List coerce(Set input) {
				return new ArrayList(input);
			}
		};
		configuration.add(new CoercionTuple<List, Set>(List.class, Set.class, listSetCoercion));
		configuration.add(new CoercionTuple<Set, List>(Set.class, List.class, setListCoercion));
	}

	/**
	 * This is a contribution to the RequestHandler service configuration. This
	 * is how we extend Tapestry using the timing filter. A common use for this
	 * kind of filter is transaction management or security. The @Local
	 * annotation selects the desired service by type, but only from the same
	 * module. Without @Local, there would be an error due to the other
	 * service(s) that implement RequestFilter (defined in other modules).
	 */
    public void contributeRequestHandler(OrderedConfiguration<RequestFilter> configuration,
            @Local
            RequestFilter filter)
    {
        // Each contribution to an ordered configuration has a name, When necessary, you may
        // set constraints to precisely control the invocation order of the contributed filter
        // within the pipeline.
        
        configuration.add("Timing", filter);
    }
}
