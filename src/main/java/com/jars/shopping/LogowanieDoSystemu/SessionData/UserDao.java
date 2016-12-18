package com.jars.shopping.LogowanieDoSystemu.SessionData;

import com.jars.shopping.Users.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.servlet.RequestDispatcher;
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

    public User getSingleUser(String userName) {
        try {
            return entityManager
                    .createNamedQuery(User.GET_USER_FROM_USERNAME, User.class)
                    .setParameter("username", userName)
                    .getSingleResult();

        } catch (EJBException e) {
            LOGGER.warn(USERDAO_MARKER, " - EJB Exception - No user found in database");
        }
        catch (NoResultException y) {
            LOGGER.warn(USERDAO_MARKER, "No results - No user found in database");
        }
        catch (IllegalStateException d) {
            LOGGER.warn(USERDAO_MARKER, "No user found in database");
        }
        return null;
    }

    public boolean passwordOK(String username, String password) {
        LOGGER.trace(USERDAO_MARKER, "Checking for correct password for user " + username);
        if (null != username && null != password) {
            LOGGER.trace(USERDAO_MARKER, "username and passwords are not null - so that's good :) ");

            try {
                User user = entityManager
                        .createNamedQuery(User.GET_USER_FROM_USERNAME, User.class)
                        .setParameter("username", username)
                        .getSingleResult();
                if (password.equals(user.getPassword())) return true;
            } catch (EJBException e) {
                LOGGER.warn(USERDAO_MARKER, "No user found in database");
            }
            catch (NoResultException y) {
                LOGGER.warn(USERDAO_MARKER, "No user found in database");
            }
            catch (IllegalStateException d) {
                LOGGER.warn(USERDAO_MARKER, "No user found in database");
            }
        }
        LOGGER.warn(USERDAO_MARKER, "Password or UserName is null or invalid");
        return false;
    }
}
