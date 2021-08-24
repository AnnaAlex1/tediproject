package com.devproject.tediproject.exception;

public class ProfessionalNotFoundException extends RuntimeException {
    public ProfessionalNotFoundException(Long id) {
        super("Could not find professional " + id);
    }
}

