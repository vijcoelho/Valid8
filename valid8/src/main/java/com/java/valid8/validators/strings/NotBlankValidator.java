package com.java.valid8.validators.strings;

import com.java.valid8.core.Rule;
import com.java.valid8.core.ValidationContext;

import java.util.Objects;

public class NotBlankValidator implements Rule<Object> {

    public NotBlankValidator() {}

    @Override
    public void validate(Object value, ValidationContext context) {
        if (Objects.isNull(value)) {
            context.addError("The value can't be null.");
        }

        if (String.valueOf(value).isBlank()) {
            context.addError("The value '" + value.toString() + "' can't be blank.");
        }
    }

}
