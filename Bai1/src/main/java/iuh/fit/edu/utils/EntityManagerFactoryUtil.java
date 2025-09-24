/*
 * @ (#) .java    1.0
 * Copyright (c)  IUH. All rights reserved.
 */
package iuh.fit.edu.utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/*
 * @description
 * @author: Huu Thai
 * @date:
 * @version: 1.0
 */
public class EntityManagerFactoryUtil {
    private static final EntityManagerFactory en ;

    static {
        try {
            en = Persistence.createEntityManagerFactory("QUANLYDIENTHOAI");
        }catch (Exception e){
            throw new ExceptionInInitializerError(e);
        }
    }
    public static EntityManager getEntityManager(){
        return en.createEntityManager();
    }
    public static void close(){
        if(en.isOpen())
            en.close();;
    }

    public static void main(String[] args) {
        getEntityManager();
    }
}
