package org.hubson404.pracadomowa5.exceptions;

public class DataProcessingException extends RuntimeException {

    public DataProcessingException(String message) {
        super("DATA PROCESSING ERROR: " + message);
    }
}
