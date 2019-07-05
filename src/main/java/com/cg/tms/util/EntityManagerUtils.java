package com.cg.tms.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtils {
	private static EntityManager entityManager;

	
	private static EntityManagerFactory initFactory() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("oracle");
		return entityManagerFactory;
	}
	public static EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory =initFactory();
		if (null==entityManager) {
			 entityManager = entityManagerFactory.createEntityManager();
		}
		else {
			return entityManager;
		}
		return entityManager;
	}

}
