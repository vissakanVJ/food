package com.tap.manager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class HibernateManager {
	Session session = null;
	void connect() {
		Configuration config = new Configuration();
		Configuration config2 = config.configure();
		SessionFactory sf = config2.buildSessionFactory();
		session = sf.openSession();
	}
}
