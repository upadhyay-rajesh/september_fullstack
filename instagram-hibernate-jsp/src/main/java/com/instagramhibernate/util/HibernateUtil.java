package com.instagramhibernate.util; // Declares the utility package.

import org.hibernate.SessionFactory; // Imports Hibernate's shared session factory.
import org.hibernate.cfg.Configuration; // Imports configuration loading support.

public final class HibernateUtil { // Holds the single application-wide SessionFactory.
	private static final SessionFactory SESSION_FACTORY; // Stores the immutable factory reference.
	static { // Initializes Hibernate once when this class is loaded.
		try { // Starts guarded configuration setup.
			SESSION_FACTORY = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory(); // Reads config
																										// and builds
																										// SessionFactory.
		} catch (Throwable error) { // Catches startup failures so the root cause is visible.
			throw new ExceptionInInitializerError(error); // Stops startup with the original cause.
		} // Ends configuration error handling.
	} // Ends the static initializer.

	private HibernateUtil() {
	} // Prevents utility class instances.

	public static SessionFactory getSessionFactory() { // Exposes the shared factory to DAO classes.
		return SESSION_FACTORY; // Returns the configured factory.
	} // Ends getter.

	public static void shutdown() { // Provides a hook for clean application shutdown.
		if (SESSION_FACTORY != null) {
			SESSION_FACTORY.close();
		} // Releases connection-pool resources.
	} // Ends shutdown method.
} // Ends HibernateUtil.
