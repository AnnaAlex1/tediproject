package com.devproject.tediproject.exception;

public class NotificationNotFoundException extends RuntimeException {
    public NotificationNotFoundException(Long id) {
        super("Could not find notification " + id);
    }
}
