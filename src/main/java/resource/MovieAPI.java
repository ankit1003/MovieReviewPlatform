package resource;


import exception.MovieNotFoundException;
import exception.UserNotFoundException;
import model.Movie;
import service.MovieOperation;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Map;

@Path("/movie")
public class MovieAPI {
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
    public String viewUser(@QueryParam("movieId") int movieId){
        try {
            return movieOperation.viewMovie(movieId).getName();
        } catch (MovieNotFoundException e) {
            return e.getMessage();
        }
    }

    @GET
    @Path("/viewReviews")
    @Produces(MediaType.APPLICATION_JSON)
    public Map viewReviews(@QueryParam("movieId") int movieId){
        try {
            return movieOperation.viewReviews(movieId);
        } catch (MovieNotFoundException e) {
            return null;
        }
    }




}
