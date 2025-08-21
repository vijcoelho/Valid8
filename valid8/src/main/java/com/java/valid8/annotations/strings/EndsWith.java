package com.java.valid8.annotations.strings;

import com.java.valid8.core.Rule;
import com.java.valid8.validators.strings.EndsWithValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface EndsWith {

    String ends();
    String message() default "The string must ends with the value.";
    Class<? extends Rule<Object>> validatedBy() default EndsWithValidator.class;

}
