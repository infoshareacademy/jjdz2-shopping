package com.jars.shopping.api;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by pwieczorek on 29.01.17.
 */
@Stateless
@Path("/")
public class DataService {

    @Path("/logins")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public UserData readUserData(){
        return new UserData();
    }

}
