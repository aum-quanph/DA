package com.webapp.webapp_be.exceptions;

import com.webapp.webapp_be.response.ErrorMessageResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(FieldValidationException.class)
    public ResponseEntity<ErrorMessageResponse> handleFieldValidationException(
            FieldValidationException ex,
            HttpServletRequest request
    ) {
        var status = ex.getStatus();

        ErrorMessageResponse body = ErrorMessageResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(status.value())
                .error(status.getReasonPhrase())
                .message(ex.getMessage())
                .path(request.getRequestURI())
                .field(ex.getField())
                .build();

        return new ResponseEntity<>(body, status);
    }
}
