package resource;

import exception.MovieNotFoundException;
import exception.ReviewNotFoundException;
import exception.UserNotFoundException;
import model.Review;
import service.impl.ReviewOperation;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/review")
public class ReviewResource {
    ReviewOperation reviewOperation = new ReviewOperation();


    @POST
    @Path("/postReview")
    @Produces(MediaType.APPLICATION_JSON)
    public Response postReview(Review review) throws UserNotFoundException, MovieNotFoundException {
        reviewOperation.postReview(review);
        return Response.status(201).entity("Review with rating " + review.getRating() +
                " for the movie " + review.getMovie().getMovieId() + " has been added by " + review.getUser().getUserId()).build();
    }

    @GET
    @Path("/viewReview")
    @Produces(MediaType.APPLICATION_JSON)
    public Response viewReview(@QueryParam("userId") int userId,@QueryParam("movieId") int movieId) throws UserNotFoundException, ReviewNotFoundException, MovieNotFoundException {
            return Response.ok(reviewOperation.viewReview(userId, movieId)).build();
    };

    @DELETE
    @Path("/deleteReview")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteReview(@QueryParam("reviewId")  int reviewId) throws ReviewNotFoundException{
        reviewOperation.deleteReview(reviewId);
        return Response.ok("Review with reviewId " + reviewId + " has been deleted ").build();
    }

}

