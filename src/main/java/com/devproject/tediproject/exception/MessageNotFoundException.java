package com.devproject.tediproject.exception;

public class MessageNotFoundException extends RuntimeException {
    public MessageNotFoundException(Long id) {
        super("Could not find message " + id);
    }
}
