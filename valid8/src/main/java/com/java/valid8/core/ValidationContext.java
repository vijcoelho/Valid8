package com.java.valid8.core;

import java.util.ArrayList;
import java.util.List;

public class ValidationContext {

    private final List<String> errors = new ArrayList<>();

    public void addError(final String message) {
        errors.add(message);
    }

    public boolean isValid() {
        return errors.isEmpty();
    }

    public List<String> getErrors() {
        return errors;
    }
}
