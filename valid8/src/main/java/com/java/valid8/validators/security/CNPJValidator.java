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
        return cnpj.matches("(\\d)\\1{13}");
    }

    private boolean isValid(final String cnpj) {
        int[] digits = new int[14];
        for (int i = 0; i < 14; i++) {
            digits[i] = Character.getNumericValue(cnpj.charAt(i));
        }

        int sum = 0;
        int[] firstWeights = {5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        for (int i = 0; i < 12; i++) {
            sum += digits[i] * firstWeights[i];
        }
        int firstCalculatedDigit = 11 - (sum % 11);
        if (firstCalculatedDigit > 9) {
            firstCalculatedDigit = 0;
        }
        if (digits[12] != firstCalculatedDigit) {
            return false;
        }

        sum = 0;
        int[] secondWeights = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        for (int i = 0; i < 13; i++) {
            sum += digits[i] * secondWeights[i];
        }
        int secondCalculatedDigit = 11 - (sum % 11);
        if (secondCalculatedDigit > 9) {
            secondCalculatedDigit = 0;
        }
        return digits[13] == secondCalculatedDigit;
    }

}