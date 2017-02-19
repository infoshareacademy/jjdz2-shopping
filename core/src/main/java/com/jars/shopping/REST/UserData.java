package com.jars.shopping.REST;

/**
 * Created by marcinpankowski on 04.02.17.
 */
public class UserData {
    private String username;
    private long date;
    private int id;


    public UserData(String username, long date) {
        this.username = username;
        this.date = date;
    }

    public UserData(String username, long date, int id) {
        this.username = username;
        this.date = date;
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public UserData() {

    }

    public String getUsername() {
        return username;
    }

    public long getDate() {
        return date;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "UserData{" +
                "username='" + username + '\'' +
                ", date=" + date +
                ", id=" + id +
                '}';
    }
}
