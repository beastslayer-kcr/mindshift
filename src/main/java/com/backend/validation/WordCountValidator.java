package com.backend.validation;

public class WordCountValidator {
    private int minWords;

    public WordCountValidator(int minWords) {
        this.minWords = minWords;
    }

    public boolean isValid(String value) {
        if (value == null || value.trim().isEmpty()) {
            return false;
        }
        String[] words = value.trim().split("\\s+");
        return words.length >= minWords;
    }
}

