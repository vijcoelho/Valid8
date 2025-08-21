package com.java.valid8.validators.numbers;

import com.java.valid8.core.Rule;
import com.java.valid8.core.ValidationContext;

import java.util.Objects;

public class NegativeValidator implements Rule<Object> {

    public NegativeValidator() {}

    @Override
    public void validate(Object value, ValidationContext context) {
        if (!(value instanceof Number number)) {
            context.addError("The value '" + (Objects.isNull(value) ? "null" : value.toString()) + "' must be a number.");
            return;
        }
        if (!(number.doubleValue() < 0)) {
            context.addError("The value '" + value.toString() + "' must be a negative number.");
        }
    }

}
