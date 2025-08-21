package com.java.valid8.fluent.fields;

import com.java.valid8.core.ValidationContext;
import com.java.valid8.fluent.Validator;
import com.java.valid8.validators.numbers.*;

import java.util.function.Function;

public class NumberAbstractBaseValidator<T> extends AbstractBaseValidator<T, Number> {

    public NumberAbstractBaseValidator(T target, Function<T, Number> getter, ValidationContext context, Validator<T> validator) {
        super(target, getter, context, validator);
    }

    public NumberAbstractBaseValidator<T> greaterThan(final Number number) {
        return (NumberAbstractBaseValidator<T>) validate(new GreaterThanValidator(number));
    }

    public NumberAbstractBaseValidator<T> digits(final Number digits, final Number decimals) {
        return (NumberAbstractBaseValidator<T>) validate(new DigitsValidator(digits.intValue(), decimals.intValue()));
    }

    public NumberAbstractBaseValidator<T> equalsOrGreaterThan(final Number number) {
        return (NumberAbstractBaseValidator<T>) validate(new EqualsOrGreaterThanValidator(number));
    }

    public NumberAbstractBaseValidator<T> max(final Number number) {
        return (NumberAbstractBaseValidator<T>) validate(new MaxValidator(number));
    }

    public NumberAbstractBaseValidator<T> negative() {
        return (NumberAbstractBaseValidator<T>) validate(new NegativeValidator());
    }

    public NumberAbstractBaseValidator<T> positive() {
        return (NumberAbstractBaseValidator<T>) validate(new PositiveValidator());
    }

    public NumberAbstractBaseValidator<T> range(final Number minValue, final Number maxValue) {
        return (NumberAbstractBaseValidator<T>) validate(new RangeValidator(minValue, maxValue));
    }
}
