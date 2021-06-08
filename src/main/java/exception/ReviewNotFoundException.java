package exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ReviewNotFoundException extends Exception implements
        ExceptionMapper<ReviewNotFoundException>
{


//    public ReviewNotFoundException() {
//        super("No Review found with given id !!");
//    }
//
//    public ReviewNotFoundException(String string) {
//        super(string);
//    }

    @Override
    public Response toResponse(ReviewNotFoundException exception)
    {
        CustomExceptionResponse customExceptionResponse = new CustomExceptionResponse(404,"Exception in get review","ReviewId not valid");
        return Response.status(404).entity(customExceptionResponse)
                .type(MediaType.APPLICATION_JSON).build();

    }

}
