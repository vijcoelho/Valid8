package com.java.valid8.annotations.dates;

import com.java.valid8.core.Rule;
import com.java.valid8.validators.dates.FutureDateValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Future {

    String message() default "The date is not in the future.";
    Class<? extends Rule<Object>> validatedBy() default FutureDateValidator.class;

}
