package com.java.valid8.core;

@FunctionalInterface
public interface Rule<T> {
    void validate(final T value, final ValidationContext context);
}
