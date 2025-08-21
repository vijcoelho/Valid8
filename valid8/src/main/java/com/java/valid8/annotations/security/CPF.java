package com.java.valid8.annotations.security;

import com.java.valid8.core.Rule;
import com.java.valid8.validators.security.CPFValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface CPF {

    String message() default "CPF is invalid.";
    Class<? extends Rule<Object>> validatedBy() default CPFValidator.class;

}
