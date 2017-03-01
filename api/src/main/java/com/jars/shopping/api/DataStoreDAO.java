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

    public List<UserDataEntity> getUserDataFromDateToDate(Long fromDate, Long toDate, String username){

        if(username == null) {
            if (fromDate == null && toDate == null) {
                return entityManager.createNamedQuery(UserDataEntity.GET_USERS).getResultList();
            } else if (fromDate == null) {
                return entityManager.createNamedQuery(UserDataEntity.GET_USERS_TO_DATE)
                        .setParameter("toDate", toDate)
                        .getResultList();
            } else if (toDate == null) {
                return entityManager.createNamedQuery(UserDataEntity.GET_USERS_FROM_DATE)
                        .setParameter("fromDate", fromDate)
                        .getResultList();
            } else {
                return entityManager.createNamedQuery(UserDataEntity.GET_USERS_FROM_DATE_TO_DATE)
                        .setParameter("fromDate", fromDate).setParameter("toDate", toDate)
                        .getResultList();
            }
        }
        else {
            if (fromDate == null && toDate == null) {
                return entityManager.createNamedQuery(UserDataEntity.GET_USERS_BY_USERNAME)
                        .setParameter("username", username)
                        .getResultList();
            } else if (fromDate == null) {
                return entityManager.createNamedQuery(UserDataEntity.GET_USERS_BY_USERNAME_TO_DATE)
                        .setParameter("username", username)
                        .setParameter("toDate", toDate)
                        .getResultList();
            } else if (toDate == null) {
                return entityManager.createNamedQuery(UserDataEntity.GET_USERS_BY_USERNAME_FROM_DATE)
                        .setParameter("username", username)
                        .setParameter("fromDate", fromDate)
                        .getResultList();
            } else {
                return entityManager.createNamedQuery(UserDataEntity.GET_USERS_BY_USERNAME_FROM_DATE_TO_DATE)
                        .setParameter("username", username)
                        .setParameter("fromDate", fromDate)
                        .setParameter("toDate", toDate)
                        .getResultList();
            }
        }
    }
}
