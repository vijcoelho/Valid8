package com.java.valid8.validators.numbers;

import com.java.valid8.annotations.numbers.Max;
import com.java.valid8.core.AnnotationRule;
import com.java.valid8.core.ValidationContext;

import java.util.Objects;

public class MaxValidator implements AnnotationRule<Max> {

    private Number maxValue;

    public MaxValidator() {}

    public MaxValidator(Number maxValue) {
        this.maxValue = maxValue;
    }

    @Override
    public void initialize(Max annotation) {
        this.maxValue = annotation.max();
    }

    @Override
    public void validate(Object value, ValidationContext context) {
        if (!(value instanceof Number number)) {
            context.addError("The value '" + (Objects.isNull(value) ? "null" : value.toString()) + "' must be a number.");
            return;
        }
        if (number.doubleValue() > maxValue.doubleValue()) {
            context.addError("The value '" + value.toString() + "' can't pass the max '" + maxValue + "'.");
        }
    }


}
