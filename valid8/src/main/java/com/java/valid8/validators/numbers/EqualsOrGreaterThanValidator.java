package com.java.valid8.validators.numbers;

import com.java.valid8.annotations.numbers.EqualsOrGreater;
import com.java.valid8.core.AnnotationRule;
import com.java.valid8.core.ValidationContext;

import java.util.Objects;

public class EqualsOrGreaterThanValidator implements AnnotationRule<EqualsOrGreater> {

    private Number minValue;

    public EqualsOrGreaterThanValidator() {}

    public EqualsOrGreaterThanValidator(Number minValue) {
        this.minValue = minValue;
    }

    @Override
    public void initialize(EqualsOrGreater annotation) {
        this.minValue = annotation.minValue();
    }

    @Override
    public void validate(final Object value, final ValidationContext context) {
        if (!(value instanceof Number number)) {
            context.addError("The value '" +(Objects.isNull(value) ? "null" : value.toString()) + "' must be a number.");
            return;
        }
        if (number.doubleValue() < minValue.doubleValue()) {
            context.addError("The value '" + value.toString() + "' must to be equals or greater than " + minValue + ".");
        }
    }


}
