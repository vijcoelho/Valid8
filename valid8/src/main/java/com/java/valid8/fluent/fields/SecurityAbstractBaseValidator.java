package com.java.valid8.fluent.fields;

import com.java.valid8.core.ValidationContext;
import com.java.valid8.fluent.Validator;
import com.java.valid8.validators.security.CNPJValidator;
import com.java.valid8.validators.security.CPFValidator;
import com.java.valid8.validators.security.StrongPasswordValidator;
import com.java.valid8.validators.security.UUIDValidator;

import java.util.function.Function;

public class SecurityAbstractBaseValidator<T> extends AbstractBaseValidator<T, String> {

    public SecurityAbstractBaseValidator(T target, Function<T, String> getter, ValidationContext context, Validator<T> validator) {
        super(target, getter, context, validator);
    }

    public SecurityAbstractBaseValidator<T> strongPassword() {
        return (SecurityAbstractBaseValidator<T>) validate(new StrongPasswordValidator());
    }

    public SecurityAbstractBaseValidator<T> uuid() {
        return (SecurityAbstractBaseValidator<T>) validate(new UUIDValidator());
    }

    public SecurityAbstractBaseValidator<T> cpf() {
        return (SecurityAbstractBaseValidator<T>) validate(new CPFValidator());
    }

    public SecurityAbstractBaseValidator<T> cnpj() {
        return (SecurityAbstractBaseValidator<T>) validate(new CNPJValidator());
    }
}
