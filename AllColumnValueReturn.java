package com.sp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.ParameterMode;
import javax.persistence.Persistence;
import javax.persistence.StoredProcedureQuery;

public class AllColumnValueReturn {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("YourPersistenceUnitName");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            entityManager.getTransaction().begin();

            StoredProcedureQuery query = entityManager.createStoredProcedureQuery("all_column_value_return");
            query.registerStoredProcedureParameter("account", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("result_text", String.class, ParameterMode.OUT);
            query.setParameter("account", "00010010010034627");

            query.execute();

            String result_text = (String) query.getOutputParameterValue("result_text");

            System.out.println("result_text: " + result_text);

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
