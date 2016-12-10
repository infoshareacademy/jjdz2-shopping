package com.jars.shopping.LogowanieDoSystemu.SessionData;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 * Created by keehoo on 26.11.16.
 */

@SessionScoped
public class SessionData implements Serializable{

    private boolean isLogged = false;
    private String name;
    private String loggedFrom;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isLogged() {
        return isLogged;
    }

    public void setLogged(boolean logged) {
        isLogged = logged;
    }

    public String getLoggedFrom() {
        return loggedFrom;
    }

    public void setLoggedFrom(String loggedFrom) {
        this.loggedFrom = loggedFrom;
    }
}
