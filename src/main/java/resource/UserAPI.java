package resource;

import model.User;
import service.UserOperation;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/user")
public class UserAPI {
    UserOperation userOperation = new UserOperation();


    @POST
    @Path("/addUser")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addMovie(User user) {
        userOperation.addUser(user);
        return Response.status(201).entity("User with name " + user.getName() + " added").build();
    }
}
