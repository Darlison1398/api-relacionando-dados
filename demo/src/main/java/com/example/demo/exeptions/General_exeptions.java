package com.example.demo.exeptions;

public class General_exeptions extends RuntimeException {

    public General_exeptions(String message) {
        super(message);
    }

    public General_exeptions(String message, Throwable cause) {
        super(message, cause);
    }
    
}
