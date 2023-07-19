package com.function;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.entity.Account;

import java.util.List;

public class AccountInfoFunction {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("YourPersistenceUnitName");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            entityManager.getTransaction().begin();

            Query query = entityManager.createNativeQuery("SELECT * FROM fun_sfs_getaccountinfodetails(:account)", Account.class);
            query.setParameter("account", "00010010010034626");

            List<Account> accountInfoList = query.getResultList();

            for (Account accountInfo : accountInfoList) {
                System.out.println("id: " + accountInfo.getId() +
                        ", coaaccountno: " + accountInfo.getCoaaccountno() +
                        ", coaaccountname: " + accountInfo.getCoaaccountname() +
                        ", coacurrencycode: " + accountInfo.getCoacurrencycode());
            }

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
