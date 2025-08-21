package com.java.valid8.validators;

import com.java.valid8.core.Rule;
import com.java.valid8.core.ValidationContext;

import java.util.Objects;

public class NotNullValidator implements Rule<Object> {

    public NotNullValidator() {}

    @Override
    public void validate(final Object value, final ValidationContext context) {
        if (Objects.isNull(value)) {
            context.addError("The value can't be null.");
        }
    }
}
