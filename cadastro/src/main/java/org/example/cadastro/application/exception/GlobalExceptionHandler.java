package org.example.cadastro.application.exception;

import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import jakarta.ws.rs.ext.Providers;
import lombok.RequiredArgsConstructor;
import org.example.cadastro.application.exception.dto.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

@Provider
@RequiredArgsConstructor
public class GlobalExceptionHandler implements ExceptionMapper<Throwable> {

    Providers providers;

    @Override
    public Response toResponse(Throwable exception) {
        if (exception instanceof ConstraintViolationException) {
            return handleConstraintViolationException((ConstraintViolationException) exception);
        } else if (exception instanceof NotFoundException) {
            return handleNotFoundException((NotFoundException) exception);
        } else if (exception instanceof IllegalArgumentException) {
            return handleIllegalArgumentException((IllegalArgumentException) exception);
        } else {
            return handleGenericException(exception);
        }
    }

    private Response handleConstraintViolationException(ConstraintViolationException exception) {
        List<ErrorMessage> errors = new ArrayList<>();
        exception.getConstraintViolations().forEach(violation
                -> errors.add(new ErrorMessage(violation.getMessage(), violation.getPropertyPath().toString())));
        return Response.status(Response.Status.BAD_REQUEST).entity(errors).build();
    }

    private Response handleNotFoundException(NotFoundException exception) {
        return Response.status(Response.Status.NOT_FOUND)
                .entity(new ErrorMessage(exception.getMessage())).build();
    }

    private Response handleIllegalArgumentException(IllegalArgumentException exception) {
        return Response.status(Response.Status.BAD_REQUEST)
                .entity(new ErrorMessage(exception.getMessage())).build();
    }

    private Response handleGenericException(Throwable exception) {
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(new ErrorMessage("Erro interno do servidor")).build();
    }
}
