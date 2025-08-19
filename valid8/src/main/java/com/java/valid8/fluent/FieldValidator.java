package com.java.valid8.fluent;

import com.java.valid8.core.ValidationContext;
import com.java.valid8.validators.EmailValidator;
import com.java.valid8.validators.GreaterThanValidator;
import com.java.valid8.validators.NotNullValidator;

import java.util.function.Function;

public class FieldValidator<T, R> {

    private final T target;
    private final Function<T, R> getter;
    private final String fieldName;
    private final ValidationContext context;
    private final Validator<T> validator;

    public FieldValidator(T target, Function<T, R> getter, String fieldName, ValidationContext context, Validator<T> validator) {
        this.target = target;
        this.getter = getter;
        this.fieldName = fieldName;
        this.context = context;
        this.validator = validator;
    }

    public Validator<T> done() {
        return validator;
    }

    public FieldValidator<T, R> greaterThan(final Number minValue) {
        final R value = getter.apply(target);

        final GreaterThanValidator rule = new GreaterThanValidator(fieldName, minValue);
        rule.validate(value, context);
        return this;
    }

    public FieldValidator<T, R> email() {
        final R value = getter.apply(target);

        final EmailValidator rule = new EmailValidator(fieldName);
        rule.validate(String.valueOf(value), context);
        return this;
    }

    public FieldValidator<T, R> notNull() {
        final R value = getter.apply(target);

        final NotNullValidator rule = new NotNullValidator(fieldName);
        rule.validate(value, context);
        return this;
    }

}
