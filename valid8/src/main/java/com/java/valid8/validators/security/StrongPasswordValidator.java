package com.java.valid8.validators.security;

import com.java.valid8.core.Rule;
import com.java.valid8.core.ValidationContext;

import java.util.Objects;

public class StrongPasswordValidator implements Rule<Object> {

    @Override
    public void validate(Object value, ValidationContext context) {
        if (!(value instanceof String password)) {
            context.addError("The value '" + (Objects.isNull(value) ? "null" : value.toString()) + "' must to be string.");
            return;
        }
        if (!(password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>/?~`])(?=\\S+$).{8,20}$"))) {
            context.addError("The value '" + value.toString() + "' is not a strong password.");
        }

    }

}
