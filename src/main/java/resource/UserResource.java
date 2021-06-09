package resource;

import exception.ReviewNotAddedException;
import exception.UserNotFoundException;
import model.Review;
import model.User;
import response.UserResponse;
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
    public Response viewUser(@QueryParam("userId") int userId) throws UserNotFoundException {
            User user = userOperation.viewUser(userId);
            UserResponse userResponse = new UserResponse();
            userResponse.setName(user.getName());
            userResponse.setNumberOfReviews(user.getNumberOfReview());
            userResponse.setViewerCategory(user.getViewerCategory());
            return Response.ok(userResponse).build();
    }


    @GET
    @Path("/viewReviews")
    @Produces(MediaType.APPLICATION_JSON)
    public Response viewReviews(@QueryParam("userId") int userId) throws UserNotFoundException, ReviewNotAddedException {
        Map map = userOperation.viewReviews(userId);
            return Response.ok(map).build();
    }
}
