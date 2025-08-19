package com.java.valid8.validators;

import com.java.valid8.core.Rule;
import com.java.valid8.core.ValidationContext;

import java.util.Objects;

public class GreaterThanValidator implements Rule<Object> {

    private final String field;
    private final Number minValue;

    public GreaterThanValidator(String field, Number minValue) {
        this.field = field;
        this.minValue = minValue;
    }

    @Override
    public void validate(final Object value, final ValidationContext context) {
        if (Objects.isNull(value)) {
            return;
        }

        if (!(value instanceof Number)) {
            context.addError("The field '" + field + "' must be a number");
        }

        final Number number = (Number) value;
        if (number.doubleValue() <= minValue.doubleValue()) {
            context.addError("The field '" + field + "' must to be greater than " + minValue + ".");
        }
    }
}
