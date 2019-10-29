package com.revature.proj2.util;

import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class SessionFactory {

	private static SessionFactory sf;

	static {
		Configuration configuration = new Configuration().configure();
		configuration.setProperty("hibernate.connection.url",
				"jdbc:postgresql://" + System.getenv("SHIFT_SHARE_URL") + ":5432/postgres?");
		configuration.setProperty("hibernate.connection.username", System.getenv("SHIFT_SHARE_USER"));
		configuration.setProperty("hibernate.connection.password", System.getenv("SHIFT_SHARE_PASS"));
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		sf = (SessionFactory) configuration.buildSessionFactory(serviceRegistry);
	}

	public static SessionFactory getSessionFactory() {
		return sf;
	}

}
