package com.jars.shopping.api;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by pwieczorek on 29.01.17.
 */
@Stateless
public class DataStoreDAO {

    @PersistenceContext
    EntityManager entityManager;

    public void putIntoDatabase(UserDataEntity userDataEntity){
        entityManager.persist(userDataEntity);
    }

    public List<UserDataEntity> getUserDataFromDateToDate(long fromDate, long toDate){
        return entityManager.createNamedQuery(UserDataEntity.GET_USERS).setParameter("fromDate", fromDate).setParameter("toDate", toDate).getResultList();
    }
}
