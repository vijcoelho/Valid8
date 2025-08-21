package com.java.valid8.fluent.fields;

import com.java.valid8.core.ValidationContext;
import com.java.valid8.fluent.Validator;
import com.java.valid8.validators.strings.*;

import java.util.function.Function;

public class StringAbstractBaseValidator<T> extends AbstractBaseValidator<T, String> {

    public StringAbstractBaseValidator(T target, Function<T, String> getter, ValidationContext context, Validator<T> validator) {
        super(target, getter, context, validator);
    }

    public StringAbstractBaseValidator<T> alpha() {
        return (StringAbstractBaseValidator<T>) validate(new AlphaValidator());
    }

    public StringAbstractBaseValidator<T> email() {
        return (StringAbstractBaseValidator<T>) validate(new EmailValidator());
    }

    public StringAbstractBaseValidator<T> maxLength(final Number number) {
        return (StringAbstractBaseValidator<T>) validate(new MaxLengthValidator(number.intValue()));
    }

    public StringAbstractBaseValidator<T> notBlank() {
        return (StringAbstractBaseValidator<T>) validate(new NotBlankValidator());
    }

    public StringAbstractBaseValidator<T> alphaNumeric() {
        return (StringAbstractBaseValidator<T>) validate(new AlphaNumericValidator());
    }

    public StringAbstractBaseValidator<T> startsWith(final String starts) {
        return (StringAbstractBaseValidator<T>) validate(new StartsWithValidator(starts));
    }

    public StringAbstractBaseValidator<T> endsWith(final String ends) {
        return (StringAbstractBaseValidator<T>) validate(new EndsWithValidator(ends));
    }
}
