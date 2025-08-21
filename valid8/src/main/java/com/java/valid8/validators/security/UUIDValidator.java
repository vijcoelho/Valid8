package com.java.valid8.validators.security;

import com.java.valid8.core.Rule;
import com.java.valid8.core.ValidationContext;
import com.java.valid8.exceptions.ValidationException;

import java.util.Objects;
import java.util.UUID;

public class UUIDValidator implements Rule<Object> {

    @Override
    public void validate(Object value, ValidationContext context) {
        if (!(value instanceof String uuidString)) {
            context.addError("The value '" + (Objects.isNull(value) ? "null" : value.toString()) + "' must be UUID.");
            return;
        }
        try {
            final UUID uuid = UUID.fromString(uuidString);
        } catch (ValidationException e) {
            context.addError("The value '" + uuidString + "' is not a correct UUID.");
        }
    }

}
