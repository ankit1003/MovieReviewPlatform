package exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class MovieNotFoundException extends Exception implements ExceptionMapper<MovieNotFoundException>
{
//    public MovieNotFoundException() {
//        super("No Movie found with given id !!");
//    }
//
//    public MovieNotFoundException(String string) {
//        super(string);
//    }

    @Override
    public Response toResponse(MovieNotFoundException exception)
    {
        CustomExceptionResponse customExceptionResponse = new CustomExceptionResponse(404,"Exception in get movie","Movie not valid");
        return Response.status(Response.Status.NOT_FOUND).entity(customExceptionResponse).build();
//        Response.status(201).entity("Movie with name " + movie.getName() + " added").build();
    }

}