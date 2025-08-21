package com.java.valid8.annotations.strings;

import com.java.valid8.core.Rule;
import com.java.valid8.validators.strings.NotBlankValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface NotBlank {

    String message() default "The string cannot be null or blank.";
    Class<? extends Rule<Object>> validatedBy() default NotBlankValidator.class;

}
