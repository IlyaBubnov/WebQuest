package com.ilyabubnov.webquest.exceptions;

public class IllegalDataFileException extends RuntimeException {

    public final static String message = "Incorrect data file for game creation.";

    public IllegalDataFileException() {
        super(message);
    }
}
