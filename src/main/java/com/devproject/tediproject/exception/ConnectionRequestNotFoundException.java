package com.devproject.tediproject.exception;

public class ConnectionRequestNotFoundException extends RuntimeException {
    public ConnectionRequestNotFoundException(Long id) {
        super("Could not find connection request " + id);
    }
}
