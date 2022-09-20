package br.com.sgsistemas.factory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
    private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("sg_erp_db");

    public static EntityManager getEntityManager(){
        return FACTORY.createEntityManager();
    }
}
