package com.jars.shopping.Users;

/**
 * Created by keehoo on 30.10.16.
 */
public abstract class User {

    public String login;
    public String password;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
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

    public void setPassword(String password) {
        this.password = password;
    }


}
