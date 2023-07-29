package com.ilyabubnov.webquest.exceptions;

public class NullGameStatusException extends RuntimeException {

    public final static String message = "Incorrect game status. Can't be null.";

    public NullGameStatusException() {
        super(message);
    }
}
