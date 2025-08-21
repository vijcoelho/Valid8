package com.java.valid8.annotations.strings;


import com.java.valid8.core.Rule;
import com.java.valid8.validators.strings.MaxLengthValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface MaxLength {

    int max();
    String message() default "The number cannot pass the max value";
    Class<? extends Rule<Object>> validatedBy() default MaxLengthValidator.class;

}
