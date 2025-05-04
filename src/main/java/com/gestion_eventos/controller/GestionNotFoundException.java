package com.gestion_eventos.controller;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class GestionNotFoundException extends RuntimeException {
    
    public GestionNotFoundException(String message) {
        super(message);
    }


}