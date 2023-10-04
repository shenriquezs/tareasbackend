package com.copeuch.fullstackbackend.exception;
/* Created by Arjun Gautam */

public class TareaNotFoundException extends RuntimeException{
    public TareaNotFoundException(Long id){
        super("Could not found the Tarea with id "+ id);
    }
}
