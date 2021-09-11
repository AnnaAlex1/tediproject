package com.devproject.tediproject.exception;

public class ContentNotFoundException extends RuntimeException{
    public ContentNotFoundException(Long id) {
        super("Could not find content " + id);
    }
}
