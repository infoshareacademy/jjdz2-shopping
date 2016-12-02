package com.jars.shopping.LogowanieDoSystemu.SessionData;

import com.jars.shopping.Users.User;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by keehoo on 27.11.16.
 */
@Stateless
public class UserDao {

    @PersistenceContext
    EntityManager entityManager;

    public void saveUserInDataBase(User user) {

        if (!getUsers().contains(user.getLogin())) {
            entityManager.persist(user);
            // TODO: Tutaj trzea dodac loggera a nie sout;a
            System.out.println("Dodano uzytkownika "+ user.getLogin()+" do bazy danych");
        }
        else System.out.println("Uzytkownik "+user.getLogin() + " juz istnieje");

        //List<String> userList = getUsers();
    }

    public List<String> getUsers() {
        return entityManager.createNamedQuery(User.GET_ALL_USERS_LIST).getResultList();
    }


}
