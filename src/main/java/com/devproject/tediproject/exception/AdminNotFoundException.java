package com.devproject.tediproject.exception;

public class AdminNotFoundException extends RuntimeException {
    public AdminNotFoundException(Long id) {
        super("Could not find admin " + id);
    }
}
