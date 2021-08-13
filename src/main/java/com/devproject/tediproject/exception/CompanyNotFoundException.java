package com.devproject.tediproject.exception;

public class CompanyNotFoundException extends RuntimeException{
    public CompanyNotFoundException(String name) {
        super("Could not find company " + name);
    }

}
