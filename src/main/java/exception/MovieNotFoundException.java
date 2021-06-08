package exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class MovieNotFoundException extends Exception implements
        ExceptionMapper<MovieNotFoundException>
{
    public MovieNotFoundException() {
        super("No Movie found with given id !!");
    }

    public MovieNotFoundException(String string) {
        super(string);
    }

    @Override
    public Response toResponse(MovieNotFoundException exception)
    {
        CustomExceptionResponse customExceptionResponse = new CustomExceptionResponse(404,"Exception in get movie","author not valid");
        return Response.status(404).entity(customExceptionResponse)
                .type(MediaType.APPLICATION_JSON).build();

    }

}