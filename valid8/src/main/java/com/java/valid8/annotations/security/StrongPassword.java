package com.java.valid8.annotations.security;

import com.java.valid8.core.Rule;
import com.java.valid8.validators.security.StrongPasswordValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface StrongPassword {

    String message() default "Password is not strong enough.";
    Class<? extends Rule<Object>> validatedBy() default StrongPasswordValidator.class;

}
