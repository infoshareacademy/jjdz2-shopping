package com.jars.shopping.api;

import javax.persistence.*;

/**
 * Created by pwieczorek on 29.01.17.
 */

@Entity
@NamedQueries({
        @NamedQuery(name = UserDataEntity.GET_USERS,
                query = "select u " +
                        "from UserDataEntity u " +
                        "where u.date >= :fromDate and " +
                        "u.date <= :toDate")
})
public class UserDataEntity {

    public static final String GET_USERS = "UserDataEntity.GET_USERS";
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
