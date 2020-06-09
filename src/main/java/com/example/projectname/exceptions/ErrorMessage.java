package com.example.projectname.exceptions;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString 
@EqualsAndHashCode
@JsonInclude(Include.NON_EMPTY)
public class ErrorMessage implements Serializable {

    private static final long serialVersionUID = 1L;

    private String message;

    private List<Error> errors = new ArrayList<>();

    public ErrorMessage(final String msg) {

        this.message = msg;
    }

    public ErrorMessage(final String msg, final List<Error> errors) {

        this.message = msg;
        this.errors = errors;
    }

    public void addError(final Error error) {

        errors.add(error);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Error> getErrors() {
        return errors;
    }

    public void setErrors(List<Error> errors) {
        this.errors = errors;
    }

}
