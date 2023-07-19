package com.sp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.ParameterMode;
import javax.persistence.Persistence;
import javax.persistence.StoredProcedureQuery;

public class SingleColumnValueReturn {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("YourPersistenceUnitName");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            entityManager.getTransaction().begin();

            StoredProcedureQuery query = entityManager.createStoredProcedureQuery("single_column_value_return");
            query.registerStoredProcedureParameter("account", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("accountName", String.class, ParameterMode.OUT);
            query.setParameter("account", "00010010010034626");

            query.execute();

            String accountName = (String) query.getOutputParameterValue("accountName");

            System.out.println("Account Name: " + accountName);

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}
