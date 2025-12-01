package com.webapp.webapp_be.exceptions;

import org.springframework.http.HttpStatus;

public class FieldValidationException extends RuntimeException {

    private final String field;
    private final HttpStatus status;

    public FieldValidationException(String field, String message) {
        this(field, message, HttpStatus.BAD_REQUEST);
    }

    public FieldValidationException(String field, String message, HttpStatus status) {
        super(message);
        this.field = field;
        this.status = status;
    }

    public String getField() {
        return field;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
