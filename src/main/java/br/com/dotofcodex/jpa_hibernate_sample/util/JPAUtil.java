package br.com.dotofcodex.jpa_hibernate_sample.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static final String PERSISTENCE_UNIT = "sample-pu";
	private static EntityManagerFactory factory;

	public static EntityManagerFactory getEntityManagerFactory() {

		if (factory == null) {
			synchronized (JPAUtil.class) {
				if (factory == null) {
					factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
				}
			}
		}

		return factory;
	}

	public static void shutdown() {
		if (factory != null) {
			factory.close();
		}
	}
}
