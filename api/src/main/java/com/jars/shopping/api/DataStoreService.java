package com.jars.shopping.api;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by pwieczorek on 29.01.17.
 */

@RequestScoped
@Path("/")
public class DataStoreService {

    @Inject
    DataStoreDAO dataStoreDAO;

    @POST
    @Path("/logins")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createNewMessage(@Valid UserData userData){
        UserDataEntity userDataEntity = new UserDataEntity();

        userDataEntity.setUsername(userData.username);
        userDataEntity.setDate(userData.date);

        dataStoreDAO.putIntoDatabase(userDataEntity);

        return Response.ok().build();
    }
}
