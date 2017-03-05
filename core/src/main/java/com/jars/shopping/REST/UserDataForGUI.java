package com.jars.shopping.REST;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * Created by marcinpankowski on 26.02.17.
 */
public class UserDataForGUI {
    private int id;
    private String username;
    private LocalDateTime date;


    public UserDataForGUI(int id, String username, long date) {
        this.id = id;
        this.username = username;
        this.date = LocalDateTime.ofInstant(Instant.ofEpochMilli(date), ZoneId.systemDefault());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
