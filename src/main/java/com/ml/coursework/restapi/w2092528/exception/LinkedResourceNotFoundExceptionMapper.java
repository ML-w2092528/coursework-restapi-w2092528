package com.ml.coursework.restapi.w2092528.exception;

import com.ml.coursework.restapi.w2092528.ErrorMessage;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class LinkedResourceNotFoundExceptionMapper implements ExceptionMapper<ResourceConflictException> {

    @Override
    public Response toResponse(ResourceConflictException exception) {
        ErrorMessage errorMessage = new ErrorMessage(
            exception.getMessage(), 
            400, 
            "https://myuniversity.edu/api/docs/errors"
        );
        
        return Response.status(Status.BAD_REQUEST)
                       .entity(errorMessage)
                       .build();
    }
}