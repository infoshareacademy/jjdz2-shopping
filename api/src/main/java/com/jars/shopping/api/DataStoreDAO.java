package com.jars.shopping.api;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by pwieczorek on 29.01.17.
 */
public class DataStoreDAO {

    @PersistenceContext
    static EntityManager entityManager;

    static public void putIntoDatabase(UserDataEntity userDataEntity){
        entityManager.persist(userDataEntity);
    }
}
