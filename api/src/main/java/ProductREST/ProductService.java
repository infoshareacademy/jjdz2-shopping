package ProductREST;

import com.jars.shopping.api.UserData;

import javax.enterprise.context.RequestScoped;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by keehoo on 04.02.17.
 */

@RequestScoped
@Path("/")
public class ProductService {

    @POST
    @Path("/product")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createNewMessage(@Valid UserData userData){

        return Response.ok().build();
    }
}
