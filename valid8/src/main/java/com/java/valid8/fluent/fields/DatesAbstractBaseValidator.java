package com.java.valid8.fluent.fields;

import com.java.valid8.core.ValidationContext;
import com.java.valid8.fluent.Validator;
import com.java.valid8.validators.dates.FutureDateValidator;
import com.java.valid8.validators.dates.PastDateValidator;

import java.time.LocalDate;
import java.util.function.Function;

public class DatesAbstractBaseValidator<T> extends AbstractBaseValidator<T, LocalDate> {

    public DatesAbstractBaseValidator(T target, Function<T, LocalDate> getter, ValidationContext context, Validator<T> validator) {
        super(target, getter, context, validator);
    }

    public DatesAbstractBaseValidator<T> past() {
        return (DatesAbstractBaseValidator<T>) validate(new PastDateValidator());
    }

    public DatesAbstractBaseValidator<T> future() {
        return (DatesAbstractBaseValidator<T>) validate(new FutureDateValidator());
    }
}
