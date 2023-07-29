package com.ilyabubnov.webquest.exceptions;

public class IllegalChoiceValueException extends RuntimeException {

    public final static String message = "Incorrect value of choice. Value need to be 1 or 2.";

    public IllegalChoiceValueException() {
        super(message);
    }
}
