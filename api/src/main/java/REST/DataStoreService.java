package REST;

import javax.enterprise.context.RequestScoped;
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
public class DataStoreService {


    @POST
    @Path("/logins")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response.ResponseBuilder createNewMessage(@Valid UserData userData){

        return Response.serverError();
    }
}
