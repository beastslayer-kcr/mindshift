package com.backend.exception;
public class SlotUnavailableException extends RuntimeException {
    public SlotUnavailableException(String message, Exception e) {
        super(message);
    }
}

