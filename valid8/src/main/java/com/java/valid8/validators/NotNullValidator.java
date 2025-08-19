package com.java.valid8.validators;

import com.java.valid8.core.Rule;
import com.java.valid8.core.ValidationContext;

import java.util.Objects;

public class NotNullValidator implements Rule<Object> {

    private final String field;

    public NotNullValidator(String field) {
        this.field = field;
    }

    @Override
    public void validate(final Object value, final ValidationContext context) {
        if (Objects.isNull(value)) {
            context.addError("The field '" + field + "' can't be null.");
        }
    }
}
