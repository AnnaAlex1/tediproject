package com.devproject.tediproject.exception;

public class PictureNotFoundException extends RuntimeException{
    public PictureNotFoundException(String url) {
        super("Could not find picture " + url);
    }
}
