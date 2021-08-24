package com.devproject.tediproject.exception;

public class VideoNotFoundException extends RuntimeException {
    public VideoNotFoundException(String url) {
        super("Could not find video " + url);
    }
}
