package resource;


import model.Movie;
import service.MovieOperation;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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




}
