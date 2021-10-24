package com.kononikhin.crud.Exceptions;

public class EntityNotFoundException extends Exception {

    private static final String TEMPLATE = "Could not find an entity with name :%s and id:%d";


    public EntityNotFoundException(String entityName, Long id) {
        super(String.format(TEMPLATE, entityName, id));
    }

}
