package com.example.projectname.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.SERVICE_UNAVAILABLE)
public class ServiceUnavailableException extends APIException {

    private static final long serialVersionUID = 1L;

    public ServiceUnavailableException(Throwable cause) {
        super(cause);
    }

    public ServiceUnavailableException(ErrorMessage error) {
        super(error);
    }

    public ServiceUnavailableException(String error) {
        super(error);
    }

}

