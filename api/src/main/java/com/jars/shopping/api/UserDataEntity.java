package com.jars.shopping.api;

import javax.persistence.*;

/**
 * Created by pwieczorek on 29.01.17.
 */

@Entity
@NamedQueries({
        @NamedQuery(name = UserDataEntity.GET_USERS_FROM_DATE_TO_DATE,
                query = "select u " +
                        "from UserDataEntity u " +
                        "where u.date >= :fromDate and " +
                        "u.date <= :toDate"),
        @NamedQuery(name = UserDataEntity.GET_USERS_FROM_DATE,
                query = "select u " +
                        "from UserDataEntity u " +
                        "where u.date >= :fromDate"),
        @NamedQuery(name = UserDataEntity.GET_USERS_TO_DATE,
                query = "select u " +
                        "from UserDataEntity u " +
                        "where u.date <= :toDate"),
        @NamedQuery(name = UserDataEntity.GET_USERS,
                query = "select u " +
                        "from UserDataEntity u"),
        @NamedQuery(name = UserDataEntity.GET_USERS_BY_USERNAME,
                query = "select u " +
                        "from UserDataEntity u " +
                        "where u.Username = :username"),
        @NamedQuery(name = UserDataEntity.GET_USERS_BY_USERNAME_FROM_DATE,
                query = "select u " +
                        "from UserDataEntity u " +
                        "where u.Username = :username and " +
                        "u.date >= :fromDate"),
        @NamedQuery(name = UserDataEntity.GET_USERS_BY_USERNAME_TO_DATE,
                query = "select u " +
                        "from UserDataEntity u " +
                        "where u.Username = :username and " +
                        "u.date <= :toDate"),
        @NamedQuery(name = UserDataEntity.GET_USERS_BY_USERNAME_FROM_DATE_TO_DATE,
                query = "select u " +
                        "from UserDataEntity u " +
                        "where u.Username = :username and " +
                        "u.date <= :toDate and u.date >= :fromDate")
})
public class UserDataEntity {

    public static final String GET_USERS_FROM_DATE_TO_DATE = "UserDataEntity.GET_USERS_FROM_DATE_TO_DATE";
    public static final String GET_USERS_FROM_DATE = "UserDataEntity.GET_USERS_FROM_DATE";
    public static final String GET_USERS_TO_DATE = "UserDataEntity.GET_USERS_TO_DATE";
    public static final String GET_USERS = "UserDataEntity.GET_USERS";
    public static final String GET_USERS_BY_USERNAME = "UserDataEntity.GET_USERS_BY_NAME";
    public static final String GET_USERS_BY_USERNAME_FROM_DATE = "UserDataEntity.GET_USERS_BY_NAME_FROM_DATE";
    public static final String GET_USERS_BY_USERNAME_TO_DATE = "UserDataEntity.GET_USERS_BY_NAME_TO_DATE";
    public static final String GET_USERS_BY_USERNAME_FROM_DATE_TO_DATE = "UserDataEntity.GET_USERS_BY_NAME_FROM_DATE_TO_DATE";

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
