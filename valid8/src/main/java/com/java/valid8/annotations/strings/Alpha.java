package com.java.valid8.annotations.strings;

import com.java.valid8.core.Rule;
import com.java.valid8.validators.strings.AlphaValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Alpha {

    String message() default "The string must to be only alpha";
    Class<? extends Rule<Object>> validatedBy() default AlphaValidator.class;

}
