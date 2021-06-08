package resource;


import exception.MovieNotFoundException;
import exception.ReviewNotAddedException;
import model.Movie;
import service.impl.MovieOperation;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Map;

@Path("/movie")
public class MovieResource {
    MovieOperation movieOperation = new MovieOperation();


    @POST
    @Path("/addMovie")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addMovie( Movie movie){
        movieOperation.addMovie(movie);
        return Response.status(201).entity("Movie with name " + movie.getName() + " added").build();
    }

    @GET
    @Path("/viewMovies")
    @Produces(MediaType.APPLICATION_JSON)
    public List viewMovies(){
        return movieOperation.viewMovies();
    }

    @GET
    @Path("/viewMovie")
    @Produces(MediaType.APPLICATION_JSON)
    public Response viewUser(@QueryParam("movieId") int movieId) throws MovieNotFoundException {
            return Response.ok(movieOperation.viewMovie(movieId).getName()).build();
    }

    @GET
    @Path("/viewReviews")
    @Produces(MediaType.APPLICATION_JSON)
    public Response viewReviews(@QueryParam("movieId") int movieId) throws MovieNotFoundException, ReviewNotAddedException {
            Map map =movieOperation.viewReviews(movieId);

//            throw new MovieNotFoundException();
            return Response.ok(map).build();
    }




}
