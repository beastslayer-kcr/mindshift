package com.backend.advice;
import com.backend.exception.ContactSetupException;
import com.backend.exception.SlotUnavailableException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobelExceptionHandler {

    @ExceptionHandler(SlotUnavailableException.class)
    public ResponseEntity<String> handleSlotUnavailableException(SlotUnavailableException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(ContactSetupException.class)
    public ResponseEntity<String> handleContactSetupException(ContactSetupException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(org.springframework.http.converter.HttpMessageNotReadableException.class)
    public ResponseEntity<String> handleHttpMessageNotReadableException(Exception e) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("Invalid date format. Please use the format dd/MM/yyyy HH:mm:ss");
    }
}

