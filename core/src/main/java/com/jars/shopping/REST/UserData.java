package com.jars.shopping.REST;

/**
 * Created by marcinpankowski on 04.02.17.
 */
public class UserData {
    private String username;
    private long date;

    public UserData(String username, long date) {
        this.username = username;
        this.date = date;
    }

    public String getUsername() {
        return username;
    }

    public long getDate() {
        return date;
    }


}
