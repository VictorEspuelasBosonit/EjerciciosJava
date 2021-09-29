package com.example.jpa.infraestructure.Exceptions;

public class UnprocessableException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public UnprocessableException(String message) {
        super(message);
    }

}