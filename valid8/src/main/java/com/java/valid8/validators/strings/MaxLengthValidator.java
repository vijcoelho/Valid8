package com.java.valid8.validators.strings;

import com.java.valid8.annotations.strings.MaxLength;
import com.java.valid8.core.AnnotationRule;
import com.java.valid8.core.ValidationContext;

import java.util.Objects;

public class MaxLengthValidator implements AnnotationRule<MaxLength> {

    private Integer maxLength;

    public MaxLengthValidator() {}

    public MaxLengthValidator(Integer maxLength) {
        this.maxLength = maxLength;
    }

    @Override
    public void initialize(MaxLength annotation) {
        this.maxLength = annotation.max();
    }

    @Override
    public void validate(Object value, ValidationContext context) {
        if (!(value instanceof String word)) {
            context.addError("The value '" + (Objects.isNull(value) ? "null" : value.toString()) + "' must to be string.");
            return;
        }
        if (!(word.length() <= maxLength)) {
            context.addError("The value length'"
                    + value.toString() +
                    "' can't be over than the max length '"
                    + maxLength + "'.");
        }
    }
}
