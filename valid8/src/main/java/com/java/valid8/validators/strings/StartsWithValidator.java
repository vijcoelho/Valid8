package com.java.valid8.validators.strings;

import com.java.valid8.annotations.strings.StartsWith;
import com.java.valid8.core.AnnotationRule;
import com.java.valid8.core.ValidationContext;

import java.util.Objects;

public class StartsWithValidator implements AnnotationRule<StartsWith> {

    private String starts;

    public StartsWithValidator() {}

    public StartsWithValidator(String starts) {
        this.starts = starts;
    }

    @Override
    public void initialize(StartsWith annotation) {
        this.starts = annotation.starts();
    }

    @Override
    public void validate(Object value, ValidationContext context) {
        if (!(value instanceof String word)) {
            context.addError("The value '" + (Objects.isNull(value) ? "null" : value.toString()) + "' must to be string.");
            return;
        }
        if (!(word.startsWith(starts))) {
            context.addError("The value '"
                    + value.toString() +
                    "' must to start with '"
                    + starts + "'.");
        }
    }

}
