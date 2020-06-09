package com.example.projectname.exceptions;

import lombok.Getter;

@Getter
public abstract class APIException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    
    private final ErrorMessage error;

    public APIException(final Throwable cause) {
        super(cause);
        this.error = new ErrorMessage(cause.getMessage());
    }

    public APIException(final ErrorMessage error) {
        super(error.getMessage());
        this.error = error;
    }

    public APIException(final String error) {
        super(error);
        this.error = new ErrorMessage(error);
    }

}
