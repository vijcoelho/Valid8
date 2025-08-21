package com.java.valid8.validators.numbers;

import com.java.valid8.annotations.numbers.Digits;
import com.java.valid8.core.AnnotationRule;
import com.java.valid8.core.ValidationContext;

import java.util.Objects;

public class DigitsValidator implements AnnotationRule<Digits> {

    private int digits;
    private int decimals;

    public DigitsValidator() {}

    public DigitsValidator(int digits, int decimals) {
        this.digits = digits;
        this.decimals = decimals;
    }

    @Override
    public void initialize(Digits annotation) {
        this.digits = annotation.digits();
        this.decimals = annotation.decimals();
    }

    @Override
    public void validate(Object value, ValidationContext context) {
        if (!(value instanceof Number)) {
            context.addError("The value '" + (Objects.isNull(value) ? "null" : value.toString()) + "' must be a number.");
            return;
        }

        final String regex = String.format("^\\d{%d}\\.\\d{%d}$", digits, decimals);
        final String numberString = String.valueOf(value);

        if (!(numberString.matches(regex))) {
            context.addError("The value '" + value.toString() + "' does not have the required number of digits before and after the decimal point.");
        }
    }

}
