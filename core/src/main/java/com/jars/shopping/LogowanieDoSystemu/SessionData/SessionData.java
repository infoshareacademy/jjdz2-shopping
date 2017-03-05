package com.jars.shopping.LogowanieDoSystemu.SessionData;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Locale;



@SessionScoped
public class SessionData implements Serializable {

    public static final Logger LOGGER = LoggerFactory.getLogger(UserDao.class);
    public static final Marker SESSION_DATA = MarkerFactory.getMarker("SESSION_DATA");

    private boolean isLogged = false;
    private String name;
    private String loggedFrom;
    private Locale locale;

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

    public void clearUserInfo() {
        LOGGER.warn(SESSION_DATA, "\n\n ---> LOGGIN USER OUT!\n ");

        setLoggedFrom("");
        setLogged(false);
        setName(null);

    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public Locale getLocale() {
        return locale;
    }
}


