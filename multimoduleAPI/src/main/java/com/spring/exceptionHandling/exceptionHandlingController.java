package com.spring.exceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class exceptionHandlingController {
    @ResponseBody
    @ExceptionHandler({contactExceptions.class})

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public String contactDoesntExistHandler(contactExceptions exception) {
        return exception.getLocalizedMessage();
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public String httpRequest400(contactExceptions exception) {
        return exception.getLocalizedMessage();
    }

    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public String serverErrorHandler(Exception exception) {
        return "Please try again, Input Error";
    }


}


