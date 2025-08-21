package com.java.valid8.validators.strings;

import com.java.valid8.annotations.strings.EndsWith;
import com.java.valid8.core.AnnotationRule;
import com.java.valid8.core.ValidationContext;

import java.util.Objects;

public class EndsWithValidator implements AnnotationRule<EndsWith> {

    private String ends;

    public EndsWithValidator() {}

    public EndsWithValidator(String ends) {
        this.ends = ends;
    }

    @Override
    public void initialize(EndsWith annotation) {
        this.ends = annotation.ends();
    }

    @Override
    public void validate(Object value, ValidationContext context) {
        if (!(value instanceof String word)) {
            context.addError("The value '" + (Objects.isNull(value) ? "null" : value.toString()) + "' must to be string.");
            return;
        }
        if (!(word.endsWith(ends))) {
            context.addError("The value '"
                    + value.toString() +
                    "' must to ends with '"
                    + ends + "'.");
        }
    }

}
