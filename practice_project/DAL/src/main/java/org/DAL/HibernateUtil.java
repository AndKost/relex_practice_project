package org.DAL;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.ejb.Ejb3Configuration;

public class HibernateUtil {
	
	public static final Log logger = LogFactory.getLog(HibernateUtil.class.getName());
	
	private static final SessionFactory sessionFactory;
	
	private static final Ejb3Configuration ejb3Configuration;
	
	static {
		try {
			
			ejb3Configuration = new Ejb3Configuration().configure("/hibernate.cfg.xml");
			sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
			
			
		} catch(Throwable ex) {
			
			logger.error("Initial SessionFactory creation failed." + ex);
		    throw new ExceptionInInitializerError(ex);
			
		}
	}
	
	public static SessionFactory getSessionFactory() {
	    return sessionFactory;
	}

	public static Ejb3Configuration getEjb3Configuration() {
	    return ejb3Configuration;
	}

}
