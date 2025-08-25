package com.java.valid8.validators.security;

import com.java.valid8.core.Rule;
import com.java.valid8.core.ValidationContext;

import java.util.Objects;

public class CPFValidator implements Rule<Object> {

    @Override
    public void validate(Object value, ValidationContext context) {
        if (!(value instanceof String cpf)) {
            context.addError("The value '" + (Objects.isNull(value) ? "null" : value.toString()) + "' must be string.");
            return;
        }
        final String formatCpf = cpf.replaceAll("[.-]", "");
        if (formatCpf.length() != 11) {
            context.addError("The value '" + cpf + "' must be 11 length.");
            return;
        }
        if (!(isValid(formatCpf))) {
            context.addError("The value '" + cpf + "' is an invalid CPF.");
        }
    }

    private boolean isValid(final String cpf) {
        int d1, d2;
        int digit1, digit2;

        int sum = 0;
        int weight = 10;
        for (int i = 0; i < 9; i++) {
            sum += Character.getNumericValue(cpf.charAt(i)) * weight;
            weight--;
        }
        d1 = 11 - (sum % 11);
        digit1 = (d1 == 10 || d1 == 11) ? 0 : d1;

        sum = 0;
        weight = 11;
        for (int i = 0; i < 10; i++) {
            sum += Character.getNumericValue(cpf.charAt(i)) * weight;
            weight--;
        }
        d2 = 11 - (sum % 11);
        digit2 = (d2 == 10 || d2 == 11) ? 0 : d2;

        return Character.getNumericValue(cpf.charAt(9)) == digit1 &&
                Character.getNumericValue(cpf.charAt(10)) == digit2;
    }

}
