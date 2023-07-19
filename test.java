package com.nativequery;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class test {
	  public static void main(String[] args) {
	        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("YourPersistenceUnitName");
	        EntityManager entityManager = entityManagerFactory.createEntityManager();

	        try {
	            Query nativeQuery = entityManager.createNativeQuery("CALL newGetAccountInfo(CAST(:account AS VARCHAR(20)),'')");
	            nativeQuery.setParameter("account", "00010010010034626");

	            String result = (String) nativeQuery.getSingleResult();

	            System.out.println("Account Name: " + result);
	        } finally {
	            entityManager.close();
	            entityManagerFactory.close();
	        }
	    }
}
