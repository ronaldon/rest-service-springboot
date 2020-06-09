package com.example.projectname.exceptions;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Builder
@ToString 
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Error implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private String field;
    
    private String errorCode;

    private String message;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String code) {
        this.errorCode = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }
}
