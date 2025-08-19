package com.java.valid8.fluent;

import com.java.valid8.core.ValidationContext;
import com.java.valid8.exceptions.ValidationException;

import java.util.function.Function;

public class Validator<T> {

    private final T target;
    private final ValidationContext context = new ValidationContext();

    public Validator(T target) {
        this.target = target;
    }

    public static <T> Validator<T> of(final T target) {
        return new Validator<>(target);
    }

    public <R> FieldValidator<T, R> require(Function<T, R> getter, String fieldName) {
        return new FieldValidator<>(target, getter, fieldName, context, this);
    }

    public void throwIfInvalid() {
        if (!context.isValid()) {
            throw new ValidationException(context.getErrors());
        }
    }
}
