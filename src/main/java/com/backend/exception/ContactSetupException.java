package com.backend.exception;
import java.lang.*;
public class ContactSetupException extends RuntimeException{
    public ContactSetupException(String message, Exception e) {
        super(message);
    }
}
