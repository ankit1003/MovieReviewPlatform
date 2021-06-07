package resource;

import model.Review;
import service.ReviewOperation;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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

}

