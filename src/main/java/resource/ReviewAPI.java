package resource;

import exception.ReviewNotFoundException;
import exception.UserNotFoundException;
import model.Review;
import service.ReviewOperation;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/review")
public class ReviewAPI {
    ReviewOperation reviewOperation = new ReviewOperation();


    @POST
    @Path("/postReview")
    @Produces(MediaType.APPLICATION_JSON)
    public Response postReview(Review review) {
        reviewOperation.postReview(review);
        return Response.status(201).entity("Review with rating " + review.getRating() +
                " for the movie " + review.getMovie() + " has been added by " + review.getUser()).build();
    }

    @GET
    @Path("/viewReview")
    @Produces(MediaType.APPLICATION_JSON)
    public Integer viewReview(@QueryParam("userId") int userId,@QueryParam("movieId") int movieId) throws ReviewNotFoundException{
        try {
            return reviewOperation.viewReview(userId, movieId);
        } catch (ReviewNotFoundException e) {
            return null;
        }
    };

    @DELETE
    @Path("/deleteReview")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteReview(@QueryParam("reviewId")  int reviewId) throws ReviewNotFoundException{
        try{
            reviewOperation.deleteReview(reviewId);
        }
        catch (ReviewNotFoundException e){
            System.out.println("Review Not Found");
        }
    }

}

