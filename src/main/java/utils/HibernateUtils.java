package utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.context.internal.ThreadLocalSessionContext;

public class HibernateUtils {

	private static SessionFactory sessionFactory;
	private static Session session;

	
	/**
	 * M�todo que devuelve el objeto Session.
	 * @return
	 * Si la sesion no esta creada: la crea y la abre.
	 * Si la sesion esta creada: simplemente devuelve la sesion abierta.
	 * 
	 */
	public static Session getSession() {
		if (sessionFactory == null) {
			session = getSessionFactory().openSession();
		}
				
		return session;
	}


	/**
	 * Metodo que cierra el objeto Session de HibernateUtils
	 */
	public static void closeSession() {
		Session session = ThreadLocalSessionContext.unbind(sessionFactory);
		if (session != null) {
			session.close();
		}
		closeSessionFactory();
	}
	
	private static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
//			StandardServiceRegistry sr = new StandardServiceRegistryBuilder().configure().build();
//			sessionFactory = new MetadataSources(sr).buildMetadata().buildSessionFactory();
			
			
	        sessionFactory = new Configuration()
	                .configure("hibernate.cfg.xml") // Cargar la configuracion desde el archivo
	                .buildSessionFactory();
			
			
		}
		return sessionFactory;
	}

	private static void closeSessionFactory() {
		if ((sessionFactory != null) && (sessionFactory.isClosed() == false)) {
			sessionFactory.close();
		}
	}

}

