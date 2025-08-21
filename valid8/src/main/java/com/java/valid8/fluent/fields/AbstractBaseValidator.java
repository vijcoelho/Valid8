package com.java.valid8.fluent.fields;

import com.java.valid8.core.Rule;
import com.java.valid8.core.ValidationContext;
import com.java.valid8.fluent.Validator;
import com.java.valid8.validators.NotNullValidator;

import java.util.function.Function;

public abstract class AbstractBaseValidator<T, R> {

    private final T target;
    private final Function<T, R> getter;
    private final ValidationContext context;
    private final Validator<T> validator;

    public AbstractBaseValidator(T target, Function<T, R> getter, ValidationContext context, Validator<T> validator) {
        this.target = target;
        this.getter = getter;
        this.context = context;
        this.validator = validator;
    }

    public Validator<T> done() {
        return validator;
    }

    protected <V extends AbstractBaseValidator<T, R>> V validate(final Rule<Object> rule) {
        rule.validate(getter.apply(target), context);
        return (V) this;
    }

    public AbstractBaseValidator<T, R> notNull() {
        return validate(new NotNullValidator());
    }
}
