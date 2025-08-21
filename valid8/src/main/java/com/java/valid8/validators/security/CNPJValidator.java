package com.java.valid8.validators.security;

import com.java.valid8.core.Rule;
import com.java.valid8.core.ValidationContext;

import java.util.Objects;

public class CNPJValidator implements Rule<Object> {

    public CNPJValidator() {
    }

    @Override
    public void validate(Object value, ValidationContext context) {
        if (!(value instanceof String cnpj)) {
            context.addError("The value '" + (Objects.isNull(value) ? "null" : value.toString()) + "' must be string.");
            return;
        }

        final String formatCnpj = cnpj.replaceAll("[^0-9]", "");

        if (formatCnpj.length() != 14) {
            context.addError("The value '" + cnpj + "' must be 14 length.");
            return;
        }

        if (isAllDigitsEqual(formatCnpj)) {
            context.addError("The value '" + cnpj + "' is an invalid CNPJ (all digits are the same).");
            return;
        }

        if (!isValid(formatCnpj)) {
            context.addError("The value '" + cnpj + "' is an invalid CNPJ.");
        }
    }

    private boolean isAllDigitsEqual(final String cnpj) {
        for (int i = 1; i < cnpj.length(); i++) {
            if (cnpj.charAt(i) != cnpj.charAt(0)) {
                return false;
            }
        }
        return true;
    }

    private Boolean isValid(final String cnpj) {
        int firstSum = 0;
        int secondSum = 0;
        int firstDigit, secondDigit;

        int[] firstWeights = {5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        int[] secondWeights = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};

        for (int i = 0; i < 12; i++) {
            int digit = Character.getNumericValue(cnpj.charAt(i));
            firstSum += digit * firstWeights[i];
        }

        firstDigit = 11 - (firstSum % 11);
        if (firstDigit > 9) {
            firstDigit = 0;
        }

        for (int i = 0; i < 13; i++) {
            int digit = Character.getNumericValue(cnpj.charAt(i));
            secondSum += digit * secondWeights[i];
        }

        secondDigit = 11 - (secondSum % 11);
        if (secondDigit > 9) {
            secondDigit = 0;
        }

        return Character.getNumericValue(cnpj.charAt(12)) == firstDigit &&
                Character.getNumericValue(cnpj.charAt(13)) == secondDigit;
    }

}