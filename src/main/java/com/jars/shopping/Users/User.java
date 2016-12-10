package com.jars.shopping.Users;

import javax.persistence.*;

/**
 * Created by keehoo on 30.10.16.
 */
@Entity
@NamedQueries({
        @NamedQuery(name= User.GET_ALL_USERS_LIST,
                query = "select u.login from User u")
})
public class User {

    final public static String GET_ALL_USERS_LIST = "User.GET_ALL_USERS_LIST";


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long id;
    private String login;
    private String password;
    private String cameFrom;
    public boolean isAdmin;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public User(String login, String password, String cameFrom, boolean isAdmin) {
        this.login = login;
        this.password = password;
        this.cameFrom = cameFrom;
        this.isAdmin = isAdmin;
    }

    public User() {
    }

    public User(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    private String getPassword() {
        return password;
    }

    private void setPassword(String password) {
        this.password = password;
    }

    public String getCameFrom() {
        return cameFrom;
    }

    public void setCameFrom(String cameFrom) {
        this.cameFrom = cameFrom;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

}
