package com.jars.shopping.LogowanieDoSystemu.SessionData;

import com.jars.shopping.Users.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Stateless
public class UserDao {

    public static final Logger LOGGER = LoggerFactory.getLogger(UserDao.class);
    public static final Marker USERDAO_MARKER = MarkerFactory.getMarker("USER_DAO");

    @PersistenceContext
    EntityManager entityManager;

    public void saveUserInDataBase(User user) {

        if (!getUsers().contains(user.getLogin())) {
            entityManager.persist(user);
            LOGGER.debug(USERDAO_MARKER, " User added to db : " + user.getLogin());
        } else LOGGER.debug(USERDAO_MARKER, " No need to add user to the database, the user exist");
    }

    public List<String> getUsers() {
        return entityManager.createNamedQuery(User.GET_ALL_USERS_LIST).getResultList();
    }

    public List<User> getAllUsers() {
        return entityManager.createNamedQuery(User.GET_ALL_USERS).getResultList();
    }
}
