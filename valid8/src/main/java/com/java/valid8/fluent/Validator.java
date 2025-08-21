package com.java.valid8.fluent;

import com.java.valid8.core.AnnotationRule;
import com.java.valid8.core.Rule;
import com.java.valid8.core.ValidationContext;
import com.java.valid8.exceptions.ValidationException;
import com.java.valid8.fluent.fields.*;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.function.Function;

public class Validator<T> {

    private final T target;
    private final ValidationContext context = new ValidationContext();

    public Validator(T target) {
        this.target = target;
    }

    public static <T> Validator<T> of(final T target) {
        final Validator<T> validator = new Validator<>(target);
        validator.validateAnnotations();
        return validator;
    }

    public NumberAbstractBaseValidator<T> requireNumber(final Function<T, Number> getter) {
        return new NumberAbstractBaseValidator<>(target, getter, context, this);
    }

    public StringAbstractBaseValidator<T> requireString(final Function<T, String> getter) {
        return new StringAbstractBaseValidator<>(target, getter, context, this);
    }

    public DatesAbstractBaseValidator<T> requireDate(final Function<T, LocalDate> getter) {
        return new DatesAbstractBaseValidator<>(target, getter, context, this);
    }

    public SecurityAbstractBaseValidator<T> requireSecurity(final Function<T, String> getter) {
        return new SecurityAbstractBaseValidator<>(target, getter, context, this);
    }

    public void throwIfInvalid() {
        if (!context.isValid()) {
            throw new ValidationException(context.getErrors());
        }
    }

    @SuppressWarnings("unchecked")
    public void validateAnnotations() {
        for (Field field : target.getClass().getDeclaredFields()) {
            for (Annotation annotation : field.getDeclaredAnnotations()) {
                try {
                    final Method validatedByMethod = annotation.annotationType().getMethod("validatedBy");

                    final Class<? extends Rule<Object>> validatorClass =
                            (Class<? extends Rule<Object>>) validatedByMethod.invoke(annotation);

                    final Rule<Object> validator = validatorClass.getConstructor().newInstance();
                    if (validator instanceof AnnotationRule) {
                        final Method initializeMethod = validator.getClass()
                                .getMethod("initialize", annotation.annotationType());
                        initializeMethod.invoke(validator, annotation);
                    }
                    field.setAccessible(true);
                    final Object value = field.get(target);
                    validator.validate(value, context);

                } catch (NoSuchMethodException e) {
                    continue;
                } catch (Exception e) {
                    System.err.println("Erro de reflexão na validação de anotação: " + e.getMessage());
                }
            }
        }
    }
}
