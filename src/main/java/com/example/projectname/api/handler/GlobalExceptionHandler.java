package com.example.projectname.api.handler;

import com.example.projectname.exceptions.APIException;
import com.example.projectname.exceptions.Error;
import com.example.projectname.exceptions.ErrorMessage;
import com.example.projectname.exceptions.ForbiddenException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.net.SocketTimeoutException;
import java.util.Locale;
import java.util.Objects;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final String EXCEPTION_LOG_MSG = "e=%s,m=%s";

    private static final String BAD_REQUEST_MSG = "Requisição inválida";

    @Autowired
    private MessageSource messageSource;

    private static void logE(final Exception e) {

        final String message = String.format(EXCEPTION_LOG_MSG, e.getClass().getSimpleName(), e.getMessage());
        log.error(message, e);
    }

    @ExceptionHandler(APIException.class)
    protected ResponseEntity<ErrorMessage> processAPIException(final APIException ex) {

        final ResponseStatus status = ex.getClass().getDeclaredAnnotation(ResponseStatus.class);
        logE(ex);
        return new ResponseEntity<>(ex.getError(), Objects.nonNull(status) ? status.code() : HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    protected void processException(final Exception ex) {

        logE(ex);
    }

    @ExceptionHandler(SocketTimeoutException.class)
    @ResponseStatus(value = HttpStatus.GATEWAY_TIMEOUT)
    protected void processSocketTimeoutException(final SocketTimeoutException ex) {

        logE(ex);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(value = HttpStatus.METHOD_NOT_ALLOWED)
    protected void processHttpRequestMethodNotSupportedException(final HttpRequestMethodNotSupportedException ex) {

        logE(ex);
    }

    @ExceptionHandler(ForbiddenException.class)
    @ResponseStatus(value = HttpStatus.FORBIDDEN)
    protected void processHttpForbiddenException(final ForbiddenException ex) {

        logE(ex);
    }

    @ExceptionHandler(TypeMismatchException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    protected void processHttpRequestMethodNotSupportedException(final TypeMismatchException ex) {

        logE(ex);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    protected void processHttpMessageNotReadableException(final HttpMessageNotReadableException ex) {

        logE(ex);
    }

    @ExceptionHandler(InvalidFormatException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public void invalidFormatException(final InvalidFormatException ex) {

        logE(ex);
    }

    @ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
    @ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
    protected void processHttpMediaTypeNotAcceptableException(final HttpMediaTypeNotAcceptableException ex) {

        logE(ex);
    }

    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    @ResponseStatus(value = HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    protected void processHttpMediaTypeNotSupportedException(final HttpMediaTypeNotSupportedException ex) {

        logE(ex);
    }

    @ExceptionHandler(BindException.class)
    public ResponseEntity<ErrorMessage> processBindException(final BindException ex) {

        logE(ex);
        return badRequest(ex);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorMessage> handleMethodArgumentNotValidException(final MethodArgumentNotValidException ex) {

        logE(ex);
        final ErrorMessage errorMessage = new ErrorMessage(BAD_REQUEST_MSG);
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errorMessage.addError(Error.builder()
                    .field(error.getField())
                    .message(getMessage(error))
                    .build());
        }
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    private String getMessage(final ObjectError objectError) {

        final String code = objectError.getDefaultMessage();
        final Object[] args = objectError.getArguments();
        return messageSource.getMessage(code, args, code, Locale.getDefault());
    }

    private ResponseEntity<ErrorMessage> badRequest(final BindException ex) {

        final ErrorMessage errorMessage = new ErrorMessage(ex.getMessage());
        for (final ObjectError error : ex.getAllErrors()) {
            errorMessage.addError(Error.builder()
                    .message(getMessage(error))
                    .build());
        }
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

}
