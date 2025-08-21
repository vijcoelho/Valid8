package com.java.valid8.annotations.numbers;

import com.java.valid8.core.Rule;
import com.java.valid8.validators.numbers.EqualsOrGreaterThanValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface EqualsOrGreater {

    double minValue();
    String message() default "The number be equals or greater than value.";
    Class<? extends Rule<Object>> validatedBy() default EqualsOrGreaterThanValidator.class;

}
