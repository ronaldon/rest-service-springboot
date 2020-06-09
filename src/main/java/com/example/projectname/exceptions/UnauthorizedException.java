package com.example.projectname.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
public class UnauthorizedException extends APIException {

    private static final long serialVersionUID = 1L;

    public UnauthorizedException(Throwable cause) {
        super(cause);
    }

    public UnauthorizedException(ErrorMessage error) {
        super(error);
    }

    public UnauthorizedException(String error) {
        super(error);
    }
}
