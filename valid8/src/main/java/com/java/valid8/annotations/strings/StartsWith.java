package com.java.valid8.annotations.strings;

import com.java.valid8.core.Rule;
import com.java.valid8.validators.strings.StartsWithValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface StartsWith {

    String starts();
    String message() default "The string must to starts with the value";
    Class<? extends Rule<Object>> validatedBy() default StartsWithValidator.class;

}
