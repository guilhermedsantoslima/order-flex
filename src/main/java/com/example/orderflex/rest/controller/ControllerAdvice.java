package com.example.orderflex.rest.controller;

import com.example.orderflex.exception.CnpjAlreadyExistsException;
import com.example.orderflex.exception.InvalidLoginException;
import com.example.orderflex.exception.NotFoundClientException;
import com.example.orderflex.rest.ApiErrors;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors handleMethodValidNotException(MethodArgumentNotValidException ex){
        List<String> errors = ex.getBindingResult().getAllErrors()
                .stream()
                .map(e -> e.getDefaultMessage())
                .collect(Collectors.toList());

        return new ApiErrors(errors);
    }

    @ExceptionHandler(NotFoundClientException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiErrors handleNotFoundUserException(NotFoundClientException e){
        return new ApiErrors(e.getMessage());
    }

    @ExceptionHandler(CnpjAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors handleCnpjAlreadyExists(CnpjAlreadyExistsException e){
        return new ApiErrors(e.getMessage());
    }

    @ExceptionHandler(InvalidLoginException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors handleInvalidLoginException(InvalidLoginException e){
        return new ApiErrors(e.getMessage());
    }
}

