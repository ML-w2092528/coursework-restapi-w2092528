
package com.ml.coursework.restapi.w2092528.exception;

import com.ml.coursework.restapi.w2092528.ErrorMessage;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class CatchAllExceptionMapper extends RuntimeException implements ExceptionMapper<Throwable> {
    public CatchAllExceptionMapper(){
        super("An internal error has occurred");
    }
    @Override
    public Response toResponse(Throwable exception) {
        ErrorMessage errorMessage = new ErrorMessage(
            this.getMessage(), 
            500, 
            "https://myuniversity.edu/api/docs/errors"
        );
        
        return Response.status(Status.INTERNAL_SERVER_ERROR)
                       .entity(errorMessage)
                       .build();
    }
}
