package org.hubson404.pracadomowa5.exceptions;

public class InsufficientDataException extends RuntimeException {
    public InsufficientDataException(String message) {
        super("BAD REQUEST: " + message);
    }
}
