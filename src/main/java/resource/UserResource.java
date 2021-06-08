package resource;

import exception.UserNotFoundException;
import model.User;
import service.impl.UserOperation;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Map;

@Path("/user")
public class UserResource {
    UserOperation userOperation = new UserOperation();


    @POST
    @Path("/addUser")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addMovie(User user) {
        userOperation.addUser(user);
        return Response.status(201).entity("User with name " + user.getName() + " added").build();
    }

    @GET
    @Path("/viewUsers")
    @Produces(MediaType.APPLICATION_JSON)
    public List viewUsers(){
        return userOperation.viewUsers();
    }

    @GET
    @Path("/viewUser")
    @Produces(MediaType.APPLICATION_JSON)
    public String viewUser(@QueryParam("userId") int userId){
        try {
            return userOperation.viewUser(userId).getName();
        } catch (UserNotFoundException e) {
            return e.getMessage();
        }
    }


    @GET
    @Path("/viewReviews")
    @Produces(MediaType.APPLICATION_JSON)
    public Map viewReviews(@QueryParam("userId") int userId){
        try {
            return userOperation.viewReviews(userId);
        } catch (UserNotFoundException e) {
            return null;
        }
    }
}
