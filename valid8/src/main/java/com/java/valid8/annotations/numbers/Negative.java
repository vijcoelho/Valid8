package com.java.valid8.annotations.numbers;

import com.java.valid8.core.Rule;
import com.java.valid8.validators.numbers.NegativeValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Negative {

    String message() default "The number must be a negative.";
    Class<? extends Rule<Object>> validatedBy() default NegativeValidator.class;

}
