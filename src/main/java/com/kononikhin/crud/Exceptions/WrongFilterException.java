package com.kononikhin.crud.Exceptions;

public class WrongFilterException extends Exception {

    private static final String TEMPLATE = "Got wrong filter name :%s";


    public WrongFilterException(String filteName) {
        super(String.format(TEMPLATE, filteName));
    }

}
