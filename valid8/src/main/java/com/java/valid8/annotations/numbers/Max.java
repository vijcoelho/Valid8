package com.java.valid8.annotations.numbers;

import com.java.valid8.core.Rule;
import com.java.valid8.validators.numbers.MaxValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Max {

    double max();
    String message() default "The number can't pass the max value.";
    Class<? extends Rule<Object>> validatedBy() default MaxValidator.class;

}
