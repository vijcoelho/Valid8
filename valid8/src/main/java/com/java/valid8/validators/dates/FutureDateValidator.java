package com.java.valid8.validators.dates;

import com.java.valid8.core.Rule;
import com.java.valid8.core.ValidationContext;

import java.time.LocalDate;
import java.util.Objects;

public class FutureDateValidator implements Rule<Object> {

    public FutureDateValidator() {}

    @Override
    public void validate(Object value, ValidationContext context) {
        if (!(value instanceof LocalDate date)) {
            context.addError("The value '" + (Objects.isNull(value) ? "null" : value.toString()) + "' must to be a LocalDate");
            return;
        }
        if (!(date.isAfter(LocalDate.now()))) {
            context.addError("The value '"
                    + value.toString() +
                    "' must to be future then the date '"
                    + LocalDate.now() + "'.");
        }
    }

}
