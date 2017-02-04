package com.jars.shopping.api;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by pwieczorek on 29.01.17.
 */

@Entity
public class UserDataEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;
    private String Username;
    private long date;

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }
}
