package com.java.valid8.annotations.strings;

import com.java.valid8.core.Rule;
import com.java.valid8.validators.strings.AlphaNumericValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface AlphaNumeric {

    String message() default "The string must be a alpha numeric.";
    Class<? extends Rule<Object>> validatedBy() default AlphaNumericValidator.class;

}
