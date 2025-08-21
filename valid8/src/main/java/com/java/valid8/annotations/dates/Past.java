package com.java.valid8.annotations.dates;

import com.java.valid8.core.Rule;
import com.java.valid8.validators.dates.PastDateValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Past {

    String message() default "The date is not in the past.";
    Class<? extends Rule<Object>> validatedBy() default PastDateValidator.class;

}
