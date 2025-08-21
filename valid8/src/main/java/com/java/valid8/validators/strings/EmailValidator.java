package com.java.valid8.validators.strings;

import com.java.valid8.core.Rule;
import com.java.valid8.core.ValidationContext;

import java.util.Objects;

public class EmailValidator implements Rule<Object> {

    public EmailValidator() {}

    @Override
    public void validate(final Object value, final ValidationContext context) {
        if (!(value instanceof String email)) {
            context.addError("The value '" + (Objects.isNull(value) ? "null" : value.toString()) + "' must to be string.");
            return;
        }
        if (!(email.matches("^[A-Za-z0-9+_.-]+@(.+)$"))) {
            context.addError("The value '" + value.toString() + "' does not have a valid email.");
        }
    }

}
