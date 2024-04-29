package com.example.orderflex.exception;

public class InvalidLoginException extends Exception{
    public InvalidLoginException() {
        super("Login inválido");
    }
}
