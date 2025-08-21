package com.java.valid8.annotations.numbers;

import com.java.valid8.core.Rule;
import com.java.valid8.validators.numbers.DigitsValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Digits {

    int digits();
    int decimals();
    String message() default "The number does not have the required number of digits.";
    Class<? extends Rule<Object>> validatedBy() default DigitsValidator.class;

}
