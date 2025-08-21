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

    private Boolean isValid(final String cpf) {

        int firstSum = 0, secondSum = 0, j = 0, z = 0, firstDigit = 0, secondDigit = 0;

        for (int i = 10; i > 1; i--) {
            firstSum += Character.getNumericValue(cpf.charAt(j)) * i;
            j++;
        }

        firstDigit = 11 - (firstSum % 11);
        if (firstDigit == 10 || firstDigit == 1) {
            firstDigit = 0;
        }

        for (int i = 11; i > 1; i--) {
            secondSum += Character.getNumericValue(cpf.charAt(j)) * i;
            z++;
        }

        secondDigit = 11 - (secondSum % 11);
        if (secondDigit == 10 || secondDigit == 1) {
            secondDigit = 0;
        }

        return Character.getNumericValue(cpf.charAt(9)) == firstDigit &&
                Character.getNumericValue(cpf.charAt(10)) == secondDigit;
    }

}
