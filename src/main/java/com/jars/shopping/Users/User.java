package com.jars.shopping.Users;

import javax.inject.Named;
import javax.persistence.*;


@Entity
@NamedQueries({
        @NamedQuery(name= User.GET_ALL_USERS_LIST,
                query = "select u.login from User u"),
        @NamedQuery(name= User.GET_ALL_USERS,
                query = "select u from User u"),
        @NamedQuery(name = User.GET_USER_FROM_USERNAME, query = "select u from User u where u.login = :username")
}
)
public class User {

    final public static String GET_ALL_USERS_LIST = "User.GET_ALL_USERS_LIST";
    final public static String GET_ALL_USERS = "User.GET_ALL_USERS";
    final public static String GET_USER_FROM_USERNAME = "User.GET_USER_FROM_USERNAME";

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

    public String getPassword() {
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

    @Override
    public String toString() {
        return "LOGIN : "+login +"\n";
    }
}
