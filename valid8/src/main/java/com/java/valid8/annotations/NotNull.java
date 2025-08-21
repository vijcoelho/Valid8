package com.java.valid8.annotations;

import com.java.valid8.core.Rule;
import com.java.valid8.validators.NotNullValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface NotNull {

    String message() default "The var can't be null";
    Class<? extends Rule<Object>> validatedBy() default NotNullValidator.class;

}
