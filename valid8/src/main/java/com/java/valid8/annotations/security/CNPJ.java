package com.java.valid8.annotations.security;

import com.java.valid8.core.Rule;
import com.java.valid8.validators.security.CNPJValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface CNPJ {

    String message() default "CNPJ is invalid.";
    Class<? extends Rule<Object>> validatedBy() default CNPJValidator.class;

}
