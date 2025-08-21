package com.java.valid8.validators.strings;

import com.java.valid8.core.Rule;
import com.java.valid8.core.ValidationContext;

import java.util.Objects;

public class AlphaValidator implements Rule<Object> {

    public AlphaValidator() {}

    @Override
    public void validate(Object value, ValidationContext context) {
        if (!(value instanceof String word)) {
            context.addError("The value '" + (Objects.isNull(value) ? "null" : value.toString()) + "' must to be string.");
            return;
        }
        if (!(word.matches("^[a-zA-Z]+$"))) {
            context.addError("The value '" + value.toString() + "' must to only have letters.");
        }
    }

}
