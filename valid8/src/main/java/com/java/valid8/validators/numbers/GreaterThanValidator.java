package com.java.valid8.validators.numbers;

import com.java.valid8.annotations.numbers.Greater;
import com.java.valid8.core.AnnotationRule;
import com.java.valid8.core.ValidationContext;

import java.util.Objects;

public class GreaterThanValidator implements AnnotationRule<Greater> {

    private Number minValue;

    public GreaterThanValidator() {}

    public GreaterThanValidator(Number minValue) {
        this.minValue = minValue;
    }

    @Override
    public void initialize(Greater annotation) {
        this.minValue = annotation.value();
    }

    @Override
    public void validate(final Object value, final ValidationContext context) {
        if (!(value instanceof Number number)) {
            context.addError("The value '" + (Objects.isNull(value) ? "null" : value.toString()) + "' must be a number.");
            return;
        }
        if (number.doubleValue() <= minValue.doubleValue()) {
            context.addError("The value '" + value.toString() + "' must to be greater than " + minValue + ".");
        }
    }
}
