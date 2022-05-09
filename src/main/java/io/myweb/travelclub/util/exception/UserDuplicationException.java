package io.myweb.travelclub.util.exception;

public class UserDuplicationException extends RuntimeException {
    //
    private static final long serialVersionUID = -7196327736293090551L;

    public UserDuplicationException(String message) {
        super(message);
    }

}
