package com.devproject.tediproject.storage;

class ImageNotFoundException extends RuntimeException {

    ImageNotFoundException(Long id) {
        super("Could not find image " + id);
    }
}
