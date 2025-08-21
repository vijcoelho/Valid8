package com.java.valid8.validators.numbers;

import com.java.valid8.annotations.numbers.Range;
import com.java.valid8.core.AnnotationRule;
import com.java.valid8.core.ValidationContext;

import java.util.Objects;

public class RangeValidator implements AnnotationRule<Range> {

    private Number minValue;
    private Number maxValue;

    public RangeValidator() {}

    public RangeValidator(Number minValue, Number maxValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    @Override
    public void initialize(Range annotation) {
        this.minValue = annotation.min();
        this.maxValue = annotation.max();
    }

    @Override
    public void validate(Object value, ValidationContext context) {
        if (!(value instanceof Number number)) {
            context.addError("The value '" + (Objects.isNull(value) ? "null" : value.toString()) + "' must be a number.");
            return;
        }
        if (number.doubleValue() < minValue.doubleValue() || number.doubleValue() > maxValue.doubleValue()) {
            context.addError("The length of the value '"
                    + value.toString() +
                    "' needs to be in a range of min value: '"
                    + minValue +
                    "' and max value: '"
                    + maxValue + "'.");
        }
    }
}
