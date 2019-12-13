package com.fsd.service.project.manager.rest.controller;

import com.fsd.service.project.manager.exception.ResourceNotFoundException;
import com.fsd.service.project.manager.exception.ProjectManagerInvalidRequestException;
import com.fsd.service.project.manager.model.ErrorMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
@Slf4j
public class ProjectManagerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ProjectManagerInvalidRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMessage handleInvalidRequestException(ProjectManagerInvalidRequestException e) {
        logger.error("ProjectManagerInvalidRequestException : {}", e);
        return buildErrorMessage(e);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMessage handleResourceNotFoundException(Exception e) {
        logger.error("ResourceNotFoundException", e);
        return buildErrorMessage(e);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorMessage handleException(Exception e) {
        logger.error("Exception", e);
        return buildErrorMessage(e);
    }

    private ErrorMessage buildErrorMessage(Exception e) {
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setCode("Unknown");
        errorMessage.setMessage(e.getMessage());
        return errorMessage;
    }

}
