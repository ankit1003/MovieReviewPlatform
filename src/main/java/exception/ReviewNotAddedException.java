package exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ReviewNotAddedException extends Exception implements ExceptionMapper<ReviewNotAddedException> {

    @Override
    public Response toResponse(ReviewNotAddedException exception) {
        return Response.ok("NO review has been added yet.").build();
    }
}
