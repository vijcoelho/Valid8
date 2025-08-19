package com.java.valid8.validators;

import com.java.valid8.core.Rule;
import com.java.valid8.core.ValidationContext;

import java.util.Objects;

public class EmailValidator implements Rule<String> {

    private final String field;

    public EmailValidator(String field) {
        this.field = field;
    }

    @Override
    public void validate(final String value, final ValidationContext context) {
        if (!value.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            context.addError("The field '" + field+ "' does not have a valid email.");
        }
    }
}
