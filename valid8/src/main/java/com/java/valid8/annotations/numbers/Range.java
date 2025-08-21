package com.java.valid8.annotations.numbers;

import com.java.valid8.core.Rule;
import com.java.valid8.validators.numbers.RangeValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Range {

    double min();
    double max();
    String message() default "The value must to be in a range from min and max value.";
    Class<? extends Rule<Object>> validatedBy() default RangeValidator.class;
    
}
