package com.java.valid8.core;

import java.lang.annotation.Annotation;

public interface AnnotationRule<A extends Annotation> extends Rule<Object> {

    void initialize(final A annotation);

}
