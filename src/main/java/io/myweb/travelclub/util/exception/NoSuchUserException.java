package io.myweb.travelclub.util.exception;

public class NoSuchUserException extends RuntimeException {
    //
    private static final long serialVersionUID = 5867172506387382920L;

    public NoSuchUserException(String message) {
        super(message);
    }
}