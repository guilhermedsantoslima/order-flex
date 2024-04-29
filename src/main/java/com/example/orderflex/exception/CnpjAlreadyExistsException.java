package com.example.orderflex.exception;

public class CnpjAlreadyExistsException extends Exception{
    public CnpjAlreadyExistsException() {
        super("Esse cnpj já existe");
    }
}