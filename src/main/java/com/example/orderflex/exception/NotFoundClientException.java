package com.example.orderflex.exception;

public class NotFoundClientException extends Exception{
    public NotFoundClientException() {
        super("Pedido não encontrado");
    }
}
