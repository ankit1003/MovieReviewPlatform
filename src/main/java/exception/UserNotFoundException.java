package exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class UserNotFoundException extends Exception implements
        ExceptionMapper<UserNotFoundException>
{


    public UserNotFoundException() {
        super("No User given with given id !!");
    }

    public UserNotFoundException(String string) {
        super(string);
    }

    @Override
    public Response toResponse(UserNotFoundException exception)
    {
        CustomExceptionResponse customExceptionResponse = new CustomExceptionResponse(404,"Exception in get User","author not valid");
        return Response.status(404).entity(customExceptionResponse)
                .type(MediaType.APPLICATION_JSON).build();

    }

}
