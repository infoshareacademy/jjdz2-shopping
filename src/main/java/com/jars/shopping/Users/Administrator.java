package com.jars.shopping.Users;

/**
 * Created by keehoo on 30.10.16.
 */
public class Administrator extends User {

    public boolean isAdmin() {
        return isAdmin;
    }

    private void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    boolean isAdmin;

    public Administrator(String login, String password) {
        super(login, password);
        setAdmin(true);
    }
}
